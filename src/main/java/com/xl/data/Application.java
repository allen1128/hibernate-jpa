package com.xl.data;

import org.hibernate.Session;

import com.xl.data.entities.User;


public class Application {
	
	public static void main(String[] args){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.close();
	}
}
