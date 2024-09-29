package dao;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

import javax.management.InstanceNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import dto.merchant;
import javax.persistence.Query;

@SuppressWarnings("all")
public class dbMerchant {
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction t = manager.getTransaction();

	public merchant saveUser(merchant user) {
		manager.persist(user);
		t.begin();
		t.commit();
		return user;
	}

	public merchant findMerchantById(int id) {
			return manager.find(merchant.class, id);
	}

	public merchant verifyUser(long phone, String password) {
		String jpql = "Select u from  merchant u where u.phone=?1 and u.password=?2";
		Query q = manager.createQuery(jpql);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		merchant user = (merchant) q.getSingleResult();

		return user;
	}

	public merchant verifyUser(int id, String password) {
		String jpql = "Select u from  merchant u where u.id=?1 and u.password=?2";
		Query q = manager.createQuery(jpql);
		q.setParameter(1, id);
		q.setParameter(2, password);
		merchant user = (merchant) q.getSingleResult();
		return user;
	}

	public List<merchant> findByName(String name) {
		String jpql = "Select u from merchant u where u.name=?1 ";
		Query q = manager.createQuery(jpql);
		q.setParameter(1, name);
		return q.getResultList();
	}

	public List<merchant> findByAge(int age) {
		String jpql = "Select u from merchant u where u.age=?1 ";
		Query q = manager.createQuery(jpql);
		q.setParameter(1, age);
		return q.getResultList();
	}

	public List<merchant> findByGender(String gender) {
		String jpql = "Select u from merchant u where u.gender=?1 ";
		Query q = manager.createQuery(jpql);
		q.setParameter(1, gender);
		return q.getResultList();
	}

	public boolean deleteUser(int id) {
		try {
			boolean flag = false;
			if (id > 0) {
				merchant user = findMerchantById(id);
				manager.remove(user);
				t.begin();
				t.commit();
				return true;
			}

		} catch (Exception e) {
			System.err.println("Merchant has been deleted already");
		}
		return false;
	}
}
