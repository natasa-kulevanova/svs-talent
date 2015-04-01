package librarydataaccess;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateDatabaseConnection {

	
	static SessionFactory sessionFactory;
	
	public static void createSessionFactory(){
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.addAnnotatedClass(Book.class).buildSessionFactory(serviceRegistry);
		
	}
	
	public static SessionFactory getSessionfactory(){
		return sessionFactory;
	}
	
	public static void closeFac(){
		sessionFactory.close();
	}
}
