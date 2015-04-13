package aliexpress.template;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import aliexpress.ali.HibernateDatabaseConnection;

@Component
public class HibernateTemplate {

	public static void doSomeAction(ActionSetter action){
		Session session = HibernateDatabaseConnection.getSessionfactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			action.someAction(session);
			tx.commit();
		}
		catch(RuntimeException e){
			if (tx != null) { tx.rollback(); }
		    throw e;
		}
		finally {
		    session.close();
		}
	}
	
	public static <T> T doListAction(ReadActionSetter<T> action) {
		T ob;
		Session session = HibernateDatabaseConnection.getSessionfactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			ob = action.readAction(session);
			tx.commit();
			return ob;
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
	
	public static boolean doCheckAction(CheckActionSetter action) {
		boolean isOK;
		Session session = HibernateDatabaseConnection.getSessionfactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			isOK = action.checkAction(session);
			tx.commit();
			return isOK;
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
}
