package nate.menuadvanced;

import nate.entities.Account;
import nate.menuadvanced.UIinterface;
import nate.services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateAccountOperation implements Operation {

	private UIinterface ui;
	private AccountService accountService;

	@Autowired
	public UpdateAccountOperation(UIinterface ui, AccountService accountService) {
		super();
		this.ui = ui;
		this.accountService = accountService;
	}

	public String getTitle() {
		return "Modify Account";
	}

	@SuppressWarnings("unused")
	public void execute() {

		String oldEmail = ui.requestInput("Enter old e-mail:");
		String oldPassword = ui.requestInput("Enter old password:");

		Account account = accountService.getUserByEmail(oldEmail);
		
		ui.print("*** Updating account: " + account.getName());

		String name = ui.requestInput("Enter new name:");
		String email = ui.requestInput("Enter new e-mail:");
		String password = ui.requestInput("Enter new password:");

		// ako nema takov account togas kreiraj go
		if (accountService.checkAccount(name, email)) {
			account.setName(name);
			account.setEmail(email);
			account.setPassword(password);
			ui.print("***Success***\n");
			accountService.updateAccount(account);
		}

		// veke postoi accoint so toj email
		else {
			System.out
					.println("User with email: " + email + " already exists!");
			System.out.println("hint: try different email.\n");
		}
	}

}
