package com.xl.data;

import java.util.Date;

import org.hibernate.Session;

import com.xl.data.entities.Address;
import com.xl.data.entities.Credential;
import com.xl.data.entities.User;

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
		
		User user = new User();
		
		Address address = new Address();
		Address address2 = new Address();
		setAddressFields(address);
		setAddressFields2(address2);
		user.getAddress().add(address);
		user.getAddress().add(address2);
		setUserFields(user);
		
		Credential credential = new Credential();
		credential.setPassword("password");
		credential.setUsername("test1234");
		credential.setUser(user);
		session.save(credential);
		
		session.getTransaction().commit();
		
	}
	

	private static void setUserFields(User user) {
		user.setAge(22);
		user.setBirthDate(new Date());
		user.setCreatedBy("kmb");
		user.setCreatedDate(new Date());
		user.setEmailAddress("kmb385");
		user.setFirstName("Kevin");
		user.setLastName("bowersox");
		user.setLastUpdatedBy("kevin");
		user.setLastUpdatedDate(new Date());
	}

	private static void setAddressFields(Address address) {
		address.setAddressLine1("Line 1");
		address.setAddressLine2("Line 2");
		address.setCity("New York");
		address.setState("NY");
		address.setZipCode("12345");
	}

	private static void setAddressFields2(Address address) {
		address.setAddressLine1("Line 3");
		address.setAddressLine2("Line 4");
		address.setCity("Corning");
		address.setState("NY");
		address.setZipCode("12345");
	}
}
