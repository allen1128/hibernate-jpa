package com.xl.data.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.MappedSuperclass;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.xl.data.dao.interfaces.UserDao;
import com.xl.data.entities.User;

public class UserHibernateDao extends AbstractDao<User, Long> implements UserDao{

	@Override
	public List<User> findByFirstName(String firstName) {
		Criterion criterion = Restrictions.eq("firstName", firstName);
		return (List<User>) findByCriteria(criterion);
	}

}
