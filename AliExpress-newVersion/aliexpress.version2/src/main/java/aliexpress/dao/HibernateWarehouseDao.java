package aliexpress.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import aliexpress.ali.HibernateDatabaseConnection;
import aliexpress.entities.Product;
import aliexpress.template.ActionSetter;
import aliexpress.template.HibernateTemplate;
import aliexpress.template.ReadActionSetter;

@SuppressWarnings("unchecked")
@Repository
public class HibernateWarehouseDao implements WarehouseDao{

	private HibernateTemplate hibernateTemplate;

	public HibernateWarehouseDao() {

	}

	@Autowired
	public HibernateWarehouseDao(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	public List<Product> listProducts() {
		return HibernateTemplate.doListAction(new ReadActionSetter<List<Product>>() {

			public List<Product> readAction(Session s) {
				List<Product> products;
				String hql = "FROM Product";
				Query query = s.createQuery(hql);
				products =  query.list();
				return products;
			}
		});
	}

	public int checkProduct(Product p) {
		int status = 0;
		Session session = HibernateDatabaseConnection.getSessionfactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			//String hql = "FROM Product WHERE name = :name AND quantity > :quantity";
			String hql = "FROM Product  WHERE name = :name";
			Query query = session.createQuery(hql);
			query.setParameter("name", p.getName());
		//	query.setParameter("quantity", p.getQuantity());
			List result = query.list();
			if(result!=null){
				Product pro = (Product) result.get(0);
				if (pro.getQuantity()<p.getQuantity())
					status = 3;
				else
					status = 1;
			}
			else{
				status=2;
			}
			
		}catch(RuntimeException e){
			if (tx != null) { tx.rollback(); }
		    throw e;
		}
		finally {
		    session.close();
		}
		return status;
	}

	public void removeFromStock(final Product p) {
		
		HibernateTemplate.doSomeAction(new ActionSetter() {
			
			public void someAction(Session s) {
				String hql = "UPDATE Product set quantity = quantity - :quantity WHERE name = :name";
				Query query = s.createQuery(hql);
				query.setParameter("quantity", p.getQuantity());
				query.setParameter("name", p.getName());
				query.executeUpdate();
				
			}
		});
	}

	public Product getProduct(final Product p) {
		Product pr;
		pr =  (Product) HibernateTemplate.doListAction(new ReadActionSetter<List<Product>>() {

			public List<Product> readAction(Session s) {
				List<Product> products;
				String hql = "FROM Product WHERE name = :name";
				Query query = s.createQuery(hql);
				query.setParameter("name", p.getName());
				products =  query.list();
				return products;
			}
		}).get(0);
		
		pr.setQuantity(p.getQuantity());
		return pr;
	}

	public void addProduct(final Product p) {
	//	final ArrayList<Product> products = ProductParser.readProducts(str);
		HibernateTemplate.doSomeAction(new ActionSetter() {
			
			public void someAction(Session s) {
		//		for(Product p : products)
					s.save(p);
			}
		});
	}

	public void deleteProduct(final String name) {
		final Product product = new Product();
		product.setName(name);
		hibernateTemplate.doSomeAction(new ActionSetter() {
			
			public void someAction(Session s) {
				s.delete(product);
				
			}
		});
	}



}
