package com.xl.data;

import java.util.Date;

import org.hibernate.Session;

import com.xl.data.entities.User;

public class Application {
	
	public static void main(String[] args){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
//		User user = new User();
//		user.setBirthDate(new Date());
//		user.setCreatedBy("me");
//		user.setCreatedDate(new Date());
//		user.setLastUpdatedDate(new Date());
//		session.save(user);
//		session.getTransaction().commit();
		session.close();
	}
}
