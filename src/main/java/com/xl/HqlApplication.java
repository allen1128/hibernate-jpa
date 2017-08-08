package com.xl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;

import com.xl.data.entities.Transaction;

public class HqlApplication {
	
	public static void main(String[] args) {
		Session session = null;
		Scanner scanner = new Scanner(System.in);
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Transaction transaction = session.beginTransaction();
			
			Query query = session.createQuery("select t from Transaction t where t.amount <= :amount and t.transactionType = 'Debit'");
			System.out.println("Please specify an amount");			
			query.setParameter("amount", new BigDecimal(scanner.next()));			
			List<Transaction> transactions = query.list();
			
			for (Transaction transaction2: transactions){
				System.out.println(transaction2.getTitle());
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
