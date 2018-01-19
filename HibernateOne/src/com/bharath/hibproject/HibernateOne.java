package com.bharath.hibproject;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bharath.hibproject.model.Address;
import com.bharath.hibproject.model.UserDetails;

public class HibernateOne {

	public static void main(String[] args) {
		UserDetails userDetails=new UserDetails();
		userDetails.setUserId(1);
		userDetails.setUserName("User one");
		Address homeadress=new Address();
		homeadress.setStreet("homestreetb");
		homeadress.setCity("homecity1");
		homeadress.setState("homestate1");
		homeadress.setZipcode("homezip1");
		
		Address officeAddress=new Address();
		
		userDetails.setOfficeAddress(officeAddress);
		userDetails.setHomeAddress(homeadress);
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails);
		
		session.getTransaction().commit();
		session.close();

	}

}
