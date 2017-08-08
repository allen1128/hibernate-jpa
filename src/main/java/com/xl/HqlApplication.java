package com.xl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.xl.data.entities.Transaction;

public class HqlApplication {
	
	/*public static void main(String[] args) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Transaction transaction = session.beginTransaction();			
			
			Query query = session.createQuery("select t from Transaction t");
			
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
	}*/

}
