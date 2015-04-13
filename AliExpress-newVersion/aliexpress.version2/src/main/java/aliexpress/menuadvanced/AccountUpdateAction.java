package aliexpress.menuadvanced;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aliexpress.entities.Account;
import aliexpress.services.AccountService;
import aliexpress.menuadvanced.UIinterface;

@Component
public class AccountUpdateAction implements Action {

	private UIinterface ui;
	private AccountService accountService;
	
	@Autowired
	public AccountUpdateAction(UIinterface ui, AccountService accountService) {
		super();
		this.ui = ui;
		this.accountService = accountService;
	} 
	
	public String getTitle() {
		return "Modify Account";
	}

	public void execute() {

		String oldEmail = ui.requestInput("e-mail");
		String oldPassword = ui.requestInput("password");
		
		Account account = accountService.getUserByEmail(oldEmail);

		String name = ui.requestInput("new name");
		String email = ui.requestInput("new e-mail");
		String password = ui.requestInput("new password");

		
		account.setName(name);
		account.setEmail(email);
		account.setPassword(password);

		accountService.updateAccount(account);
		
	}

}
