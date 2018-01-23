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
		UserDetails userDetails=new UserDetails();
		
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleModel("MODEL S");
		userDetails.setUserName("User one");
		userDetails.setVehicle(vehicle);
		/*SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();*/
		Configuration configuration=new Configuration().configure();
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().
										applySettings(configuration.getProperties()).
										build();
		SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();

		
		
	}

}
