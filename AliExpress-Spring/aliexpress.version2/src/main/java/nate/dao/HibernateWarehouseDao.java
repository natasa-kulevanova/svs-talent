package nate.dao;

import java.util.List;

import nate.ali.HibernateDatabaseConnection;
import nate.entities.Product;
import nate.template.ActionSetter;
import nate.template.HibernateTemplate;
import nate.template.ReadActionSetter;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

	@SuppressWarnings("rawtypes")
	public int checkProduct(Product p) {
		int status = 0;
		Session session = HibernateDatabaseConnection.getSessionfactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String hql = "FROM Product  WHERE name=:name";
			Query query = session.createQuery(hql);
			query.setParameter("name", p.getName());
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
		Product pr = HibernateTemplate.doListAction(new ReadActionSetter<List<Product>>() {

			public List<Product> readAction(Session s) {
				String hql = "FROM Product WHERE name = :name";
				Query query = s.createQuery(hql);
				query.setParameter("name", p.getName());  
				return query.list();
			}
		}).get(0);
		
		pr.setQuantity(p.getQuantity());
		return pr;
	}

	public Product getProductByName(final String name) {
		return HibernateTemplate
				.doListAction(new ReadActionSetter<Product>() {
				
					@SuppressWarnings("rawtypes")
					@Override
					public Product readAction(Session s) {
						Criteria criteria = s.createCriteria(Product.class);
						criteria.add(Restrictions.eqProperty("name", name));
						List results = criteria.list();
						return (Product) results.get(0);
					}
				});
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

	@SuppressWarnings("static-access")
	public void deleteProduct(final String name) {
		final Product product = new Product();
		product.setName(name);
		hibernateTemplate.doSomeAction(new ActionSetter() {
			
			public void someAction(Session s) {
				s.delete(product);
				
			}
		});
	}

	@Override
	public void updateProduct(final Product p) {
		HibernateTemplate.doSomeAction(new ActionSetter() {
			
			public void someAction(Session s) {
		//		for(Product p : products)
					s.save(p);
			}
		});
		
	}



}
