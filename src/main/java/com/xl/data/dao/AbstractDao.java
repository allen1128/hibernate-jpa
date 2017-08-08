package com.xl.data.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import com.xl.data.dao.interfaces.Dao;

public abstract class AbstractDao<T, ID extends Serializable> implements Dao<T, ID> {
	
	private Class<T> persistentClass;
	private Session session;
	
	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(ID id) {
		return (T) getSession().load(this.getPersistentClass(), id);
	}

	@Override
	public List<T> findAll() {
		return this.findByCriteria();
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion ... criterion){
		Criteria criteria = this.getSession().createCriteria(this.getPersistentClass());
		for (Criterion c : criterion){
			criteria.add(c);
		}
		
		return (List<T>) criteria.list();
	}

	@Override
	public T save(T entity) {
		this.getSession().saveOrUpdate(entity);
		return entity;
	}
	
	@Override
	public void delete(T entity) {
		this.getSession().delete(entity);		
	}

	@Override
	public void flush() {
		this.getSession().flush();		
	}

	@Override
	public void clear() {
		this.getSession().clear();		
	}

	@Override
	public void setSession(Session session) {
		this.session = session;		
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public Session getSession() {
		return session;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

}
