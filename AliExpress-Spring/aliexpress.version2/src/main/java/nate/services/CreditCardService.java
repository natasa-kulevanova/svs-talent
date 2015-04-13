package nate.services;

import java.util.Date;

import nate.dao.CreditCardDao;
import nate.entities.CreditCard;
import nate.template.CheckActionSetter;
import nate.template.HibernateTemplate;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public CreditCard getCardByNumber(long num){
		return cardDao.getCreditCard(num);
	}
}
