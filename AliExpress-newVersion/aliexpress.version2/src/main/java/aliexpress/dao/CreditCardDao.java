package aliexpress.dao;

import aliexpress.entities.CreditCard;

public interface CreditCardDao {

	public void registerCreditCard(CreditCard c);

	public void deleteCreditCard(CreditCard c);

	public void updateCreditCard(CreditCard c);
	
}
