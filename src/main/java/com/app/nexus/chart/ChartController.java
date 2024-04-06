package com.app.nexus.chart;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.nexus.entity.Insurance;
import com.app.nexus.services.InsuranceServices;

@Controller
public class ChartController {
	@Autowired
	private InsuranceServices insuranceService;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@GetMapping("/monthlyInsuranceChart")
	public String monthlyInsuranceChart(Model model) {
	// Fetch data from the insurance table
	List<Insurance> insuranceList = insuranceService.findAll();
	
	// Create a map to store monthly cashless and reimbursement counts
	Map<String, Map<String, Integer>> monthlyData = new LinkedHashMap<>();
	
	// Analyze the data and categorize cases by month
	for (Insurance insurance : insuranceList) {
		LocalDate creationDate = insurance.getPolicyDate().toLocalDate();
		String monthYear = creationDate.getMonth() + " " + creationDate.getYear();
		String insuranceType = insurance.getInsuranceType();

		// Initialize the month data if not already present
		monthlyData.putIfAbsent(monthYear, new HashMap<>());
	
		// Increment the count based on insurance type
		Map<String, Integer> monthMap = monthlyData.get(monthYear);
		monthMap.put(insuranceType, monthMap.getOrDefault(insuranceType, 0) + 1);
	}
	
	// Create the chart
	logger.info("calling createMonthlyChart");
	JFreeChart chart = createMonthlyChart(monthlyData);
	logger.info("After createMonthlyChart");
	// Convert the chart to a byte array
	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	try {
		ChartUtilities.writeChartAsPNG(outputStream, chart, 950, 550);
	} catch (IOException e) {
		logger.info("Error Occure during Image creation");
		e.printStackTrace();
	}
	byte[] chartBytes = outputStream.toByteArray();
	
	// Convert the byte array to Base64 for displaying in HTML
	String chartBase64 = Base64.getEncoder().encodeToString(chartBytes);
	
	// Add the chartBase64 string to the model
	model.addAttribute("chartBase64", chartBase64);
	
	return "monthlyInsuranceChart";
	}
	
	// Helper method to create the monthly chart
	private JFreeChart createMonthlyChart(Map<String, Map<String, Integer>> monthlyData) {
		// Create a dataset for the chart
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		// Add data to the dataset
		for (String monthYear : monthlyData.keySet()) {
			Map<String, Integer> monthMap = monthlyData.get(monthYear);
			for (String insuranceType : monthMap.keySet()) {
				dataset.addValue(monthMap.get(insuranceType), insuranceType, monthYear);
			}
		}	
	// Create the chart
	JFreeChart chart = ChartFactory.createBarChart(
			"Monthly (Cashless vs Reimbursement) Insurance Cases",
			"Month", "Number of Cases", dataset,
			PlotOrientation.VERTICAL, true, true, false);
	return chart;
	}

	@GetMapping("/pie-chart")
	public String showPieChart(Model model) {
		List<Insurance> allInsurances = insuranceService.findAll();
		int totalCashless = 0;
		int totalReimbursement = 0;
		
		for (Insurance insurance : allInsurances) {
			if (insurance.getInsuranceType().equalsIgnoreCase("Cashless")) {
				totalCashless++;
			} else if (insurance.getInsuranceType().equalsIgnoreCase("Reimbursment")) {
				totalReimbursement++;
			}
		}

		int totalCases = totalCashless + totalReimbursement;
		double cashlessPercentage = (double) totalCashless / totalCases * 100;
		double reimbursementPercentage = (double) totalReimbursement / totalCases * 100;

		Map<String, Double> dataMap = new HashMap<>();
		dataMap.put("Cashless", cashlessPercentage);
		dataMap.put("Reimbursement", reimbursementPercentage);
		
		model.addAttribute("dataMap", dataMap);
		return "pie-chart";
	}
}