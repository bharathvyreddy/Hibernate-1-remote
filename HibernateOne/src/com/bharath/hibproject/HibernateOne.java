package com.bharath.hibproject;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bharath.hibproject.model.UserDetails;

public class HibernateOne {

	public static void main(String[] args) {
		UserDetails userDetails=new UserDetails();
		userDetails.setUserId(1);
		userDetails.setUserName("User one");
		userDetails.setAddress("first address");
		userDetails.setJoinDate(new Date());
		userDetails.setDescription("My description 1");
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();

	}

}
