package com.xl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;

import com.xl.data.entities.Account;
import com.xl.data.entities.Transaction;

public class HqlApplication {
	
	public static void main(String[] args) {
		Session session = null;
		Scanner scanner = new Scanner(System.in);
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Transaction transaction = session.beginTransaction();
			
			Query query = session.createQuery("select distinct t.account from Transaction t " 
					+ "where t.amount >= 100 and lower(t.transactionType) = 'debit'");
			@SuppressWarnings("unchecked")
			List<Account> accounts = query.list();
			
			for (Account account: accounts){
				System.out.println(account.getName());
			}
			transaction.commit();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}

}
