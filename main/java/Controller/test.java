package Controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

class test {
	public static void main(String[] args) {

		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		System.out.println(manager);
	}
}
