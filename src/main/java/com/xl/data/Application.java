package com.xl.data;

import java.util.Date;

import org.hibernate.Session;

import com.xl.data.entities.User;

public class Application {
	
	public static void main(String[] args){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		User user = new User();
		user.setBirthDate(new Date());
		user.setCreatedBy("me");
		user.setEmailAddress("test@test.com");
		user.setFirstName("first");
		user.setLastName("last");
		user.setCreatedDate(new Date());
		user.setLastUpdatedDate(new Date());
		user.setLastUpdatedBy("me");
		session.save(user);
		session.getTransaction().commit();
		
		session.beginTransaction();		
		User fromDbUser = (User) session.get(User.class, user.getUserId());
		//fromDbUser.setCreatedBy("you");
		fromDbUser.setEmailAddress("newtest@test.com");
		session.update(fromDbUser);
		session.getTransaction().commit();
		session.close();
	}
}
