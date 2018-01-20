package com.bharath.hibproject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.bharath.hibproject.model.Address;
import com.bharath.hibproject.model.UserDetails;

public class HibernateOne {

	public static void main(String[] args) {
		UserDetails userDetails=new UserDetails();
		userDetails.setUserName("User one");
		Address homeadress=new Address();
		homeadress.setStreet("homestreetb");
		homeadress.setCity("homecity1");
		homeadress.setState("homestate1");
		homeadress.setZipcode("homezip1");
		
		Address officeAddress=new Address();
		officeAddress.setStreet("Office Street");
		officeAddress.setCity("Office City");
		officeAddress.setState("Office State");
		officeAddress.setZipcode("Office zip");
		
		userDetails.getListOfAdresses().add(officeAddress);
		userDetails.getListOfAdresses().add(homeadress);
		
		/*SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();*/
		Configuration configuration=new Configuration().configure();
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().
										applySettings(configuration.getProperties()).
										build();
		SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
		session.close();

		userDetails=null;
		session=sessionFactory.openSession();
		userDetails=(UserDetails) session.get(UserDetails.class, 1);
		session.close();
		System.out.println("ID "+userDetails.getUserId());
		System.out.println("Size"+userDetails.getListOfAdresses().size());
		
	}

}
