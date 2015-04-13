package nate.dao;

import java.util.List;

import nate.entities.Account;
import nate.template.ActionSetter;
import nate.template.CheckActionSetter;
import nate.template.HibernateTemplate;
import nate.template.ReadActionSetter;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

	@SuppressWarnings("static-access")
	public void deleteAccount(final Account a) {
		hibernateTemplate.doSomeAction(new ActionSetter() {

			public void someAction(Session s) {
				s.delete(a);

			}
		});
	}

	@SuppressWarnings("static-access")
	public void updateAccount(final Account a) {
		hibernateTemplate.doSomeAction(new ActionSetter() {

			public void someAction(Session s) {
				s.update(a);

			}
		});
	}

	
	//check if account exists
	@SuppressWarnings("static-access")
	public boolean checkAccount(final String name, final String email) {

		return hibernateTemplate.doCheckAction(new CheckActionSetter() {

			@SuppressWarnings("rawtypes")
			public boolean checkAction(Session s) {
				String hql = "FROM Account WHERE name=:name AND email=:email";
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

	@SuppressWarnings("static-access")
	public Account getUserById(final int id) {
		return hibernateTemplate.doListAction(new ReadActionSetter<Account>() {

					public Account readAction(Session s) {
						Account a = (Account) s.get(Account.class, id);
						return a;
					}
				});
	}

	@SuppressWarnings("static-access")
	public Account getUserByEmail(final String email) {
		return hibernateTemplate.doListAction(new ReadActionSetter<Account>() {

					@SuppressWarnings("rawtypes")
					public Account readAction(Session s) {
						String hql = "FROM Account WHERE email = :email";
						Query query = s.createQuery(hql);
						query.setParameter("email", email);
						List result = query.list();
						return (Account) result.get(0);
					/*	Criteria criteria = s.createCriteria(Account.class);
						criteria.add(Restrictions.eqProperty("email", email));
						List results = criteria.list();
						return (Account) results.get(0);*/
					}
				});
	}
}
