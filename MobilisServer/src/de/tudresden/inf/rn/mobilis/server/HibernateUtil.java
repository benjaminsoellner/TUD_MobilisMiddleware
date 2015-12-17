package de.tudresden.inf.rn.mobilis.server;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	
	private static final ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<Session>();
	private static final ThreadLocal<Transaction> transactionThreadLocal = new ThreadLocal<Transaction>();
	
	
	static {
		AnnotationConfiguration ac = new AnnotationConfiguration().configure("/META-INF/hibernate.xml");
		sessionFactory = ac.buildSessionFactory();
	}
	
	public static Session getSession() {
		Session s = HibernateUtil.sessionThreadLocal.get();
		if (s == null) {
			s = HibernateUtil.sessionFactory.openSession();            
			HibernateUtil.sessionThreadLocal.set(s);
		} 
		return s;
	}
	
	public static void closeSession() throws HibernateException {
		Session s = HibernateUtil.sessionThreadLocal.get();
		HibernateUtil.sessionThreadLocal.set(null);
		if (s != null && s.isOpen()) s.close();
	}
	
	public static void beginTransaction() throws HibernateException {
		try {
			Transaction t = transactionThreadLocal.get();
			if (t == null) {
				t = getSession().beginTransaction();
				transactionThreadLocal.set(t);
			}
		} catch(Exception e) { throw new HibernateException(e); }
	}
	
	public static void commitTransaction() throws HibernateException {
		try {
			Transaction t = transactionThreadLocal.get();
			if(t != null && !t.wasCommitted() && !t.wasRolledBack()) {
				t.commit();
				transactionThreadLocal.set(null);
			}
		} catch(Exception e) {
			HibernateUtil.rollBackTransaction();
			throw new HibernateException(e);
		}
	}
	
	public static void rollBackTransaction() throws HibernateException {
		Transaction t = (Transaction) transactionThreadLocal.get();
		transactionThreadLocal.set(null);
		try {
			if(t != null && !t.wasCommitted() && !t.wasRolledBack())
				t.rollback();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
}
