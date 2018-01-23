package com.bharath.hibproject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


import com.bharath.hibproject.model.UserDetails;
import com.bharath.hibproject.model.Vehicle;

public class HibernateOne {

	public static void main(String[] args) {
		UserDetails userDetails1=new UserDetails();
		UserDetails userDetails2=new UserDetails();
		
		Vehicle vehicle1=new Vehicle();
		vehicle1.setVehicleModel("MODEL 1");
		vehicle1.getUserDetailsList().add(userDetails1);
		Vehicle vehicle2=new Vehicle();
		vehicle2.setVehicleModel("MODEL 2");
		vehicle2.getUserDetailsList().add(userDetails2);
		
		
		userDetails1.setUserName("User one");
		userDetails1.getVehicleList().add(vehicle1);
		
		userDetails2.setUserName("User Two");
		userDetails2.getVehicleList().add(vehicle2);
		/*SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();*/
		Configuration configuration=new Configuration().configure();
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().
										applySettings(configuration.getProperties()).
										build();
		SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails1);
		session.save(userDetails2);
		session.save(vehicle1);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();

		
		
	}

}
