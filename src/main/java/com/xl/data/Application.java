package com.xl.data;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;

import com.xl.data.entities.Account;
import com.xl.data.entities.Budget;
import com.xl.data.entities.Transaction;

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
		Budget budget = new Budget();
		budget.setGoalAmount(new BigDecimal("10000.00"));
		budget.setName("Emergency Fund");
		budget.setPeriod("Yearly");		
		budget.getTransactions().add(createNewBeltPurchase(account));
		budget.getTransactions().add(createShoePurchase(account));
		session.save(budget);
		transaction.commit();
		
		Transaction transaction2 = (Transaction) session.get(Transaction.class, account.getTransactions().get(0).getTransactionId());
		System.out.println("account name:" + transaction2.getAccount().getName());
	}

	private static Transaction createNewBeltPurchase(Account account) {
		Transaction beltPurchase = new Transaction();
		beltPurchase.setTitle("Dress Belt 2");
		beltPurchase.setAmount(new BigDecimal("50.00"));
		beltPurchase.setClosingBalance(new BigDecimal("0.00"));
		beltPurchase.setCreatedBy("Kevin Bowersox");
		beltPurchase.setCreatedDate(new Date());
		beltPurchase.setInitialBalance(new BigDecimal("0.00"));
		beltPurchase.setLastUpdatedBy("Kevin Bowersox");
		beltPurchase.setLastUpdatedDate(new Date());
		beltPurchase.setNotes("New Dress Belt");
		beltPurchase.setTransactionType("Debit");
		beltPurchase.setAccount(account);
		account.getTransactions().add(beltPurchase);
		return beltPurchase;
	}

	private static Transaction createShoePurchase(Account account) {
		Transaction shoePurchase = new Transaction();
		shoePurchase.setTitle("Work Shoes 2");
		shoePurchase.setAmount(new BigDecimal("100.00"));
		shoePurchase.setClosingBalance(new BigDecimal("0.00"));
		shoePurchase.setCreatedBy("Kevin Bowersox");
		shoePurchase.setCreatedDate(new Date());
		shoePurchase.setInitialBalance(new BigDecimal("0.00"));
		shoePurchase.setLastUpdatedBy("Kevin Bowersox");
		shoePurchase.setLastUpdatedDate(new Date());
		shoePurchase.setNotes("Nice Pair of Shoes");
		shoePurchase.setTransactionType("Debit");
		shoePurchase.setAccount(account);
		account.getTransactions().add(shoePurchase);
		return shoePurchase;
	}

	private static Account createNewAccount() {
		Account account = new Account();
		account.setCloseDate(new Date());
		account.setOpenDate(new Date());
		account.setCreatedBy("Kevin Bowersox");
		account.setInitialBalance(new BigDecimal("50.00"));
		account.setName("Savings Account 3");
		account.setCurrentBalance(new BigDecimal("100.00"));
		account.setLastUpdatedBy("Kevin Bowersox");
		account.setLastUpdatedDate(new Date());
		account.setCreatedDate(new Date());
		
		return account;
	}
}
