package nate.dao;

import nate.entities.PurchaseOrder;
import nate.template.ActionSetter;
import nate.template.HibernateTemplate;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class HibernatePurchaseOrderDao implements PurchaseOrderDao {

	@Override
	public void registerPurchaseOrder(final PurchaseOrder po) {
		HibernateTemplate.doSomeAction(new ActionSetter() {

			@Override
			public void someAction(Session s) {
				s.save(po);
			}
		});
	}

	@Override
	public void unregisterPurchaseOrder(final PurchaseOrder po) {
		HibernateTemplate.doSomeAction(new ActionSetter() {

			public void someAction(Session s) {

				s.delete(po);
			}
		});
	}
}
