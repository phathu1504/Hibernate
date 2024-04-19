package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jakarta.persistence.Query;
import model.Cat;
import utils.HibernateUtils;

public class CatDAO implements DAOInterface<Cat> {
	List<Cat> list = new ArrayList<Cat>();

	@Override
	public List<Cat> selectAll() {
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();

				String hql = "from Cat";
				Query query = session.createQuery(hql, Cat.class);
				list = query.getResultList();

				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Khong truy van select duoc: " + e.getLocalizedMessage());
			list = null;
		}
		return list;
	}

	public Cat selectById(Cat cat) {
		Cat cat1 = null;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();

//				String hql = "from Cat c Where c.id = :id";
//				Query query = session.createQuery(hql, Cat.class);
//				query.setParameter("id", cat.getId());
//				cat1 = (Cat) query.getSingleResult();

				cat1 = session.get(Cat.class, cat.getId());

				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Khong truy van select duoc: " + e.getLocalizedMessage());
		}
		return cat1;
	}

	@Override
	public boolean inser(Cat t) {
		boolean result = false;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();

				session.save(t);
				result = true;

				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Khong truy van select duoc: " + e.getLocalizedMessage());
		}
		return result;
	}

	@Override
	public boolean update(Cat t) {
		boolean result = false;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();

				session.saveOrUpdate(t);
				result = true;

				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Khong truy van select duoc: " + e.getLocalizedMessage());
		}
		return result;
	}

	@Override
	public boolean delete(Cat t) {
		boolean result = false;
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();

				session.delete(t);
				result = true;

				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Khong truy van select duoc: " + e.getLocalizedMessage());
		}
		return result;
	}

}
