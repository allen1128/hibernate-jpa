package com.xl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.xl.data.entities.Account;
import com.xl.data.entities.Transaction;

public class HibernateApplication {

	public static void main(String[] args) {
		Session session = null;
		Scanner scanner = new Scanner(System.in);
		int pageNumber = 3;
		int pageSize = 5;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Transaction transaction = session.beginTransaction();
			
			Criterion criterion = Restrictions.ge("amount",  new BigDecimal("20.00"));
			Criterion criterion2 = Restrictions.eq("transactionType", "Debit");
			Criteria criteria = session.createCriteria(Transaction.class).add(Restrictions.and(criterion, criterion2)).addOrder(Order.desc("title"));
			criteria.setFirstResult((pageNumber - 1) * pageSize);
			criteria.setMaxResults(pageSize);
			List<Transaction> transactions = criteria.list();			
			for (Transaction transaction1 : transactions) {
				System.out.println(transaction1.getAmount());
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
