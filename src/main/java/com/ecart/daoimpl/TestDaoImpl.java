package com.ecart.daoimpl;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecart.dao.ITestDao;
import com.ecart.model.DataClass;

@Repository
public class TestDaoImpl implements ITestDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private void closeSession(Session session) {
		if (session != null && session.isOpen())
			session.close();
	}
	
	
	@Override
	public boolean saveOrUpdateCustomer(final DataClass dataClass) {
		Session session = null;
		Transaction txn = null;
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			session.saveOrUpdate(dataClass);
			txn.commit();
			return true;
		} catch (final HibernateException he) {
			if (txn != null)
				txn.rollback();
			throw he;
		} finally {
			closeSession(session);
		}
	}

	
	@Override
	public DataClass loadDataClassRowId(Long customerId) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Criteria crit = session.createCriteria(DataClass.class).add(Restrictions.eq("id", customerId));
			return (DataClass) crit.uniqueResult();
		} catch (final HibernateException he) {
			throw he;
		} finally {
			closeSession(session);
		}
	}
}
