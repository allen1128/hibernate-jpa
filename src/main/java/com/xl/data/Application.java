package com.xl.data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import org.hibernate.Session;

import com.xl.data.entities.Account;
import com.xl.data.entities.Address;
import com.xl.data.entities.Credential;
import com.xl.data.entities.User;

public class Application {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction transaction = session.beginTransaction();

		/*
		 * User user = new User(); Address address = new Address();
		 * user.setAge(22); user.setBirthDate(new Date());
		 * user.setCreatedBy("Kevin"); user.setCreatedDate(new Date());
		 * user.setEmailAddress("kmb3"); user.setFirstName("kevin");
		 * user.setLastName("bowersox"); user.setLastUpdatedBy("kmb");
		 * user.setLastUpdatedDate(new Date());
		 * 
		 * address.setAddressLine1("line 1"); address.setAddressLine2("line2");
		 * address.setCity("Philadelphia"); address.setState("PA");
		 * address.setZipCode("12345");
		 * 
		 * user.setAddress(address);
		 */

		/*User user = new User();

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
		user.setCredential(credential);
		session.save(credential);*/
		
		Account account = createNewAccount();
		Account account2 = createNewAccount();
		User user = createUser();
		User user2 = createUser();
		
		account.getUsers().add(user);
		account.getUsers().add(user2);
		account2.getUsers().add(user);
		account2.getUsers().add(user2);
		
		session.save(account);
		session.save(account2);
		transaction.commit();
		
		User user3 = (User) session.get(User.class, user.getUserId());
		System.out.println("account name:" + user3.getFirstName());
	}
	private static Credential createCredential(User user) {
		Credential credential = new Credential();
		credential.setUser(user);
		credential.setUsername("test_username");
		credential.setPassword("test_password");
		return credential;
	}

	private static Address createAddress() {
		Address address = new Address();
		address.setAddressLine1("101 Address Line");
		address.setAddressLine2("102 Address Line");
		address.setCity("New York");
		address.setState("PA");
		address.setZipCode("10000");
		return address;
	}

	private static User createUser() {
		User user = new User();
		user.setAddress(Arrays.asList(new Address[]{createAddress()}));
		user.setBirthDate(new Date());
		user.setCreatedBy("Kevin Bowersox");
		user.setCreatedDate(new Date());
		user.setCredential(createCredential(user));
		user.setEmailAddress("test@test.com");
		user.setFirstName("John 2");
		user.setLastName("Doe");
		user.setLastUpdatedBy("system");
		user.setLastUpdatedDate(new Date());
		return user;
	}

	private static Account createNewAccount() {
		Account account = new Account();
		account.setCloseDate(new Date());
		account.setOpenDate(new Date());
		account.setCreatedBy("Kevin Bowersox");
		account.setInitialBalance(new BigDecimal("50.00"));
		account.setName("Savings Account 2");
		account.setCurrentBalance(new BigDecimal("100.00"));
		account.setLastUpdatedBy("Kevin Bowersox");
		account.setLastUpdatedDate(new Date());
		account.setCreatedDate(new Date());
		return account;
	}
}
