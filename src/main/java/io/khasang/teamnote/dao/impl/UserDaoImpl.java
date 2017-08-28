package io.khasang.teamnote.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import io.khasang.teamnote.dao.UserDao;
import io.khasang.teamnote.entity.User;

/**
 * Implementation of DAO for {@link User} entity.
 * 
 * @author MickeyMouse
 */
@Repository
public class UserDaoImpl extends BasicDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	public User getByAccountName(String accountName) {
		CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
		Root<User> usersRoot = criteriaQuery.from(User.class);
		criteriaQuery.select(usersRoot);
		criteriaQuery.where(builder.equal(usersRoot.get("accountName"), accountName));
		// Account name is unique in the database, see the unique constraint in the User entity. That is why it is
		// impossible that multiple users will be found. Either a single user will be found or no user. That is why we
		// use uniqueResult(), not list().
		return sessionFactory.getCurrentSession().createQuery(criteriaQuery).uniqueResult();
	}

	@Override
	public User getByEmail(String email) {
		CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
		Root<User> usersRoot = criteriaQuery.from(User.class);
		criteriaQuery.select(usersRoot);
		criteriaQuery.where(builder.equal(usersRoot.get("email"), email));
		// Email address is unique in the database, see the unique constraint in the User entity. That is why it is
		// impossible that multiple users will be found. Either a single user will be found or no user. That is why we
		// use uniqueResult(), not list().
		return sessionFactory.getCurrentSession().createQuery(criteriaQuery).uniqueResult();
	}

	@Override
	public List<User> getByPersonName(String firstName, String lastName) {
		CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
		Root<User> usersRoot = criteriaQuery.from(User.class);
		criteriaQuery.select(usersRoot);
		criteriaQuery.where(builder.and(builder.equal(usersRoot.get("firstName"), firstName),
				builder.equal(usersRoot.get("lastName"), lastName)));
		// Unlike account name and Email address that are unique the person names are not unique. That is why multiple
		// persons can be found for given first and last name. That is why we use list(), not uniqueResult().
		return sessionFactory.getCurrentSession().createQuery(criteriaQuery).list();
	}

}
