package nate.ali;

import nate.entities.Account;
import nate.entities.CreditCard;
import nate.entities.Product;
import nate.entities.PurchaseOrder;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateDatabaseConnection {

	static SessionFactory sessionFactory;
	
	public static void createSessionFactory(){
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
				applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.addAnnotatedClass(Product.class)
				.addAnnotatedClass(Account.class)
				.addAnnotatedClass(CreditCard.class)
				.addAnnotatedClass(PurchaseOrder.class)
				.buildSessionFactory(serviceRegistry);
	}
	
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}

	public static void closeFac() {
		sessionFactory.close();
	}
}
