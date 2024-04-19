package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Cat;
import utils.HibernateUtils;

public class TestCat {
	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Cat cat1 = new Cat("Cam", null, false);
					session.save(cat1);
				} finally {
					// TODO: handle finally clause
					session.close();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Loi test cat: " + e.getLocalizedMessage());
		}

	}
}
