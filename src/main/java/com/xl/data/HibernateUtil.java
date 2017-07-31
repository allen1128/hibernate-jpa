package com.xl.data;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.xl.data.entities.User;

public class HibernateUtil {	
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		SessionFactory sessionFactory = null;
		try {
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(User.class);
			sessionFactory = configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
		} catch (Exception ex){
			ex.printStackTrace();
			throw new RuntimeException("Error building session factory");
		}
		
		return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
