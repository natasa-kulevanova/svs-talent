package aliexpress.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import aliexpress.entities.Account;
import aliexpress.template.ActionSetter;
import aliexpress.template.CheckActionSetter;
import aliexpress.template.HibernateTemplate;
import aliexpress.template.ReadActionSetter;

@Repository
public class HibernateAccountDao implements AccountDao{
	private HibernateTemplate hibernateTemplate;

	@Autowired
	public HibernateAccountDao(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void registerAccount(final Account a) {
		HibernateTemplate.doSomeAction(new ActionSetter() {

			public void someAction(Session s) {
				s.save(a);
			}
		});
	}

	public void deleteAccount(final Account a) {
		hibernateTemplate.doSomeAction(new ActionSetter() {

			public void someAction(Session s) {
				s.delete(a);

			}
		});
	}

	public void updateAccount(final Account a) {
		hibernateTemplate.doSomeAction(new ActionSetter() {

			public void someAction(Session s) {
				s.update(a);

			}
		});
	}

	
	//check if account exists
	public boolean checkAccount(final String name, final String email) {

		return hibernateTemplate.doCheckAction(new CheckActionSetter() {

			public boolean checkAction(Session s) {
				String hql = "FROM Account WHERE name = :name AND email = :email";
				Query query = s.createQuery(hql);
				query.setParameter("name", name);
				query.setParameter("email", email);
				List result = query.list();
				if (result != null) {
					return true;
				} else {
					return false;
				}
			}
		});
	}

	public Account getUserById(final int id) {
		return hibernateTemplate
				.doListAction(new ReadActionSetter<Account>() {

					public Account readAction(Session s) {
						Account a = (Account) s.get(Account.class, id);
						return a;
					}
				});
	}

	public Account getUserByEmail(final String email) {
		return hibernateTemplate
				.doListAction(new ReadActionSetter<Account>() {

					public Account readAction(Session s) {
						Criteria criteria = s.createCriteria(Account.class);
						criteria.add(Restrictions.eqProperty("email", email));
						List results = criteria.list();
						return (Account) results.get(0);
					}
				});
	}
}
