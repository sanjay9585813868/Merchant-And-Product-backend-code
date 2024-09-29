package dao;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dto.merchant;
import dto.product;

@SuppressWarnings("all")
public class dbproduct {
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction t = manager.getTransaction();


	public product saveProduct(product Product) {
		manager.persist(Product);
		t.begin();
		t.commit();
		return Product;
	}
	
	public product findpdtById(int id) {
		return manager.find(product.class, id);
	}

	
	public List<product> findByName(String name) {
		String jpql = "Select u from product u where u.name=?1 ";
		Query q = manager.createQuery(jpql);
		q.setParameter(1, name);
		return q.getResultList();
		
}
	public List<product> findByBrand(String brand) {
		String jpql = "Select u from product u where u.brand=?1 ";
		Query q = manager.createQuery(jpql);
		q.setParameter(1, brand);
		return q.getResultList();
	}
	public List<product> findNameByCost(double cost) {
		String jpql = "Select u from product u where u.cost=?1 ";
		Query q = manager.createQuery(jpql);
		q.setParameter(1, cost);
		return q.getResultList();
	}
	
	public boolean deletepdt(int id) {
		try {
			boolean flag=false;
			if (id>0) {
				product pdt = findpdtById(id);
				manager.remove(pdt);
				t.begin();
				t.commit();
				return true;
			} 
			
		} catch (Exception e) {
			System.err.println("Product hasbeen deleted already");
		}
		return false;
	
	}

}