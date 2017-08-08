package com.xl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.xl.data.entities.Account;

import javassist.expr.NewArray;

public class JpqlApplication {	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EntityManagerFactory factory = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try{
			factory = Persistence.createEntityManagerFactory("finance");
			em = factory.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			/*Query query = em.createQuery("select distinct t.account.accountId, concat(concat(t.account.name, ' '), t.account.accountId) from Transaction t " 
					+ "where t.amount >= 100 and t.transactionType like '%ebit'  order by t.title ");*/
			Query query = em.createNamedQuery("Account.debitAccountDynamicQuery");
			query.setParameter("amount",new BigDecimal("99"));
			List<Object[]> objects = query.getResultList();
			
			for (Object[] o: objects){
				System.out.println(o[0]);
				System.out.println(o[1]);
			}
			
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			em.close();
			factory.close();
		}
	}
}
