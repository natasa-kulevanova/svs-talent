package aliexpress.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aliexpress.dao.AccountDao;
import aliexpress.entities.Account;
import aliexpress.template.CheckActionSetter;
import aliexpress.template.HibernateTemplate;

@Service
public class AccountService {

AccountDao accountDao;
	
	@Autowired
	public AccountService(AccountDao a){
		this.accountDao = a;
	}
	
	public void registerAccount(Account a){
		accountDao.registerAccount(a);
	}
	
	public void deleteAccount(Account a){
		accountDao.deleteAccount(a);
	}
	
	public void updateAccount(Account a){
		accountDao.updateAccount(a);
	}
	
	public boolean checkAccount(final String n, final String e){
		return HibernateTemplate.doCheckAction(new CheckActionSetter() {

			public boolean checkAction(Session s) {
				String hql = "FROM Account WHERE name = :name AND email = :email";
				Query query = s.createQuery(hql);
				query.setParameter("name", n);
				query.setParameter("email", e);
				List result = query.list();
				if (result != null) {
					return true;
				} else {
					return false;
				}
			}
		});
	}

	public Account getUserById(int i){
		return accountDao.getUserById(i);
	}
	public Account getUserByEmail(String email){
		return accountDao.getUserByEmail(email);
	}
}
