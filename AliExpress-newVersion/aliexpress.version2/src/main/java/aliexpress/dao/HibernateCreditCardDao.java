package aliexpress.dao;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import aliexpress.entities.CreditCard;
import aliexpress.template.ActionSetter;
import aliexpress.template.HibernateTemplate;


@SuppressWarnings("unchecked")
@Repository
public class HibernateCreditCardDao implements CreditCardDao{

	
	private HibernateTemplate hibernateTemplate;

	@Autowired
	public HibernateCreditCardDao(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	public void registerCreditCard(final CreditCard c){
		hibernateTemplate.doSomeAction(new ActionSetter() {
			
			public void someAction(Session s) {
				s.save(c);
				
			}
		});
	}
	
	public void deleteCreditCard(final CreditCard c){
		hibernateTemplate.doSomeAction(new ActionSetter() {
			
			public void someAction(Session s) {
				s.delete(c);
				
			}
		});
	}
	
	public void updateCreditCard(final CreditCard c){
		hibernateTemplate.doSomeAction(new ActionSetter() {
				
				public void someAction(Session s) {
					s.update(c);
					
				}
			});
		}
}
