/**
 * 
 */
package io.khasang.teamnote.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.khasang.teamnote.dao.UserDao;
import io.khasang.teamnote.entity.User;

/**
 * @author MickeyMouse
 *
 */
@Repository
public class UserDaoImpl extends BasicDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	public User getByAccountName(String accountName) {
		EntityManager em = getCurrentSession().getEntityManagerFactory().createEntityManager();
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.accountName = :accountName", User.class);
		query.setParameter("accountName", accountName);
		List<User> users = query.getResultList();
		if (!users.isEmpty()) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@Override
	public User getByEmail(String email) {
		EntityManager em = getCurrentSession().getEntityManagerFactory().createEntityManager();
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
		query.setParameter("email", email);
		List<User> users = query.getResultList();
		if (!users.isEmpty()) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<User> getByPersonName(String firstName, String lastName) {
		EntityManager em = getCurrentSession().getEntityManagerFactory().createEntityManager();
		TypedQuery<User> query = em.createQuery(
				"SELECT u FROM User u WHERE u.firstName = :firstName and u.lastName = :lastName", User.class);
		query.setParameter("firstName", firstName);
		query.setParameter("lastName", lastName);
		return query.getResultList();
	}

}
