package com.app.nexus.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;

import com.app.nexus.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

//	@Autowired
//	private SessionFactory sessionFactory;
	
	private EntityManager entityManager;

	@Autowired
	public UserDaoImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}

	@Override
	public User findByUserName(String theUserName) {

		// retrieve/read from database using username
		TypedQuery<User> theQuery = entityManager.createQuery("from User where userName=:uName", User.class);
		theQuery.setParameter("uName", theUserName);

		User theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		} catch (Exception e) {
			theUser = null;
		}

		return theUser;
	}

	@Override
	@Transactional
	public void save(User theUser) {

		// create the user ... finally LOL
		entityManager.merge(theUser);
	}

	@Override
	public List<String> findAllUsernames() {
		TypedQuery<String> query = entityManager.createQuery("SELECT u.userName FROM User u", String.class);
		return query.getResultList();
    }

	/*
	 * @Override public List<User> findAll() { Session currentSession =
	 * sessionFactory.getCurrentSession();
	 * 
	 * // Retrieve all users using HQL Query<User> query =
	 * currentSession.createQuery("from User", User.class); return
	 * query.getResultList(); }
	 */}