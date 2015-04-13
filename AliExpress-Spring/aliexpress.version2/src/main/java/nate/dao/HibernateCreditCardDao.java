package nate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import nate.entities.CreditCard;
import nate.template.ActionSetter;
import nate.template.HibernateTemplate;
import nate.template.ReadActionSetter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class HibernateCreditCardDao implements CreditCardDao {

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public HibernateCreditCardDao(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	@SuppressWarnings("static-access")
	public void registerCreditCard(final CreditCard c) {
		hibernateTemplate.doSomeAction(new ActionSetter() {

			public void someAction(Session s) {
				s.save(c);

			}
		});
	}

	@SuppressWarnings("static-access")
	public void deleteCreditCard(final CreditCard c) {
		hibernateTemplate.doSomeAction(new ActionSetter() {

			public void someAction(Session s) {
				s.delete(c);

			}
		});
	}

	@SuppressWarnings("static-access")
	public void updateCreditCard(final CreditCard c) {
		hibernateTemplate.doSomeAction(new ActionSetter() {

			public void someAction(Session s) {
				s.update(c);

			}
		});
	}

	@SuppressWarnings("static-access")
	@Override
	public CreditCard getCreditCard(final long num) {
		CreditCard card = hibernateTemplate.doListAction(new ReadActionSetter<List<CreditCard>>() {

					@Override
					public List<CreditCard> readAction(Session s) {
						String hql = "FROM CreditCard WHERE cardNumber=:num";
						Query query = s.createQuery(hql);
						query.setParameter("cardNumber", num);
						return query.list();

					}
				}).get(0);

		return card;

	}
}
