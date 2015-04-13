package aliexpress.services;

import java.util.Date;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aliexpress.dao.CreditCardDao;
import aliexpress.entities.CreditCard;
import aliexpress.template.CheckActionSetter;
import aliexpress.template.HibernateTemplate;

@Service
public class CreditCardService {

CreditCardDao cardDao;
	
	@Autowired
	public CreditCardService(CreditCardDao c){
		cardDao = c;
	}
	
	public void registerCreditCard(CreditCard c){
		cardDao.registerCreditCard(c);
	}

	public void deleteCreditCard(CreditCard c){
		cardDao.deleteCreditCard(c);
	}

	public void updateCreditCard(CreditCard c){
		cardDao.updateCreditCard(c);
	}
	
	public boolean checkCreditCard(final CreditCard c){
		return HibernateTemplate.doCheckAction(new CheckActionSetter() {

			public boolean checkAction(Session s) {
				Date date = new Date();
				if(c.getExpDate().before(date)){
					return false;
				}
				else
					return true;
			}
		});
	}
}
