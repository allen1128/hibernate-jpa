package com.xl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import com.xl.data.entities.Transaction;

public class JpaApplication {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EntityManagerFactory factory = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		int pageNumber = 1;
		int pageSize = 5;
		
		try{
			factory = Persistence.createEntityManagerFactory("finance");
			em = factory.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			//select * from transaction t where amount = '20.00' and transac
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Transaction> cq = cb.createQuery(Transaction.class);
			Root<Transaction> root = cq.from(Transaction.class);
			Path<BigDecimal> amountPath = root.get("amount");
			Path<String> transactionTypePath = root.get("transactionType");				
			cq.select(root).where(cb.and(cb.gt(amountPath, new BigDecimal("20.00"))), cb.equal(transactionTypePath, "Debit"));			
			TypedQuery<Transaction> query = em.createQuery(cq);
			query.setFirstResult((pageNumber-1) * pageSize);
			query.setMaxResults(pageSize);
			List<Transaction> transactions = query.getResultList();
			for (Transaction transaction : transactions){
				System.out.println(transaction.getTitle());
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
