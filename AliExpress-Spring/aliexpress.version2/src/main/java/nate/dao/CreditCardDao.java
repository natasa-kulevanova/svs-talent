package nate.dao;



import nate.entities.CreditCard;

public interface CreditCardDao {

	public void registerCreditCard(CreditCard c);

	public void deleteCreditCard(CreditCard c);

	public void updateCreditCard(CreditCard c);
	
	public CreditCard getCreditCard(long num);
}
