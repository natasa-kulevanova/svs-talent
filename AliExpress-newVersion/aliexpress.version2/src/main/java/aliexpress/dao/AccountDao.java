package aliexpress.dao;

import aliexpress.entities.Account;

public interface AccountDao {

	public void registerAccount(Account a);
	public void deleteAccount(Account a);
	public void updateAccount(Account a);
	public boolean checkAccount(String name, String email);
	public Account getUserById(int id);
	public Account getUserByEmail(String email);
}
