package com.xl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.xl.data.entities.Account;
import com.xl.data.entities.Transaction;

public class JpqlApplication {	
	/*public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EntityManagerFactory factory = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try{
			factory = Persistence.createEntityManagerFactory("finance");
			em = factory.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			TypedQuery<Account> query = em.createQuery("select distinct a from Transaction t " 
					+ "join t.account a where t.amount >= 100 and t.transactionType like '%ebit'  order by t.title ", Account.class);
			System.out.println("Please specify an amount");			
			query.setParameter(1, new BigDecimal(scanner.next()));		
			List<Account> accounts = query.getResultList();
			
			for (Account account: accounts){
				System.out.println(account.getName());
			}
			
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			factory.close();
		}
	}*/
}
