package nate.menuadvanced;

import nate.menuadvanced.AccountAdvancedMenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountManagementOperation implements Operation {

	private AccountAdvancedMenu menu;

	@Autowired
	public AccountManagementOperation(AccountAdvancedMenu menu) {
		super();
		this.menu = menu;
	}

	public String getTitle() {
		return "Account management";
	}


	public void execute() {
		menu.run();
	}
}
