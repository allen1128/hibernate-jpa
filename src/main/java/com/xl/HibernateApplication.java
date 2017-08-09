package com.xl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.xl.data.entities.Account;
import com.xl.data.entities.Transaction;

public class HibernateApplication {

	public static void main(String[] args) {
		Session session = null;
		Scanner scanner = new Scanner(System.in);

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Transaction.class).addOrder(Order.desc("title"));
			List<Account> accounts = criteria.list();
			
			for (Account account : accounts) {
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
