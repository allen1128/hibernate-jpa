package com.xl.data;

import java.util.Date;

import org.hibernate.Session;

import com.xl.data.entities.Bank;

public class Application {
	
	public static void main(String[] args){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
			
		/*User user = new User();
		Address address = new Address();
		user.setAge(22);
		user.setBirthDate(new Date());
		user.setCreatedBy("Kevin");
		user.setCreatedDate(new Date());
		user.setEmailAddress("kmb3");
		user.setFirstName("kevin");
		user.setLastName("bowersox");
		user.setLastUpdatedBy("kmb");
		user.setLastUpdatedDate(new Date());
		
		address.setAddressLine1("line 1");
		address.setAddressLine2("line2");
		address.setCity("Philadelphia");
		address.setState("PA");
		address.setZipCode("12345");
		
		user.setAddress(address);*/
		
		Bank bank = new Bank();
		bank.setName("Federal Trust");
		bank.setAddressLine1("33 Wall Street");
		bank.setAddressLine2("Suite 233");
		bank.setCity("New York");
		bank.setState("NY");
		bank.setZipCode("12345");
		bank.setInternational(false);
		bank.setCreatedBy("Kevin");
		bank.setCreatedDate(new Date());
		bank.setLastUpdatedBy("Kevin");
		bank.setLastUpdatedDate(new Date());
		bank.getContacts().add("Joe");
		bank.getContacts().add("Mary");			
		session.save(bank);
		
		
		session.save(bank);
		session.getTransaction().commit();
		
	}
}
