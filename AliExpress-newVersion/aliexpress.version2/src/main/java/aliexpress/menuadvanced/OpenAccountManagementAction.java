package aliexpress.menuadvanced;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aliexpress.menuadvanced.AccountAdvancedMenu;

@Component
public class OpenAccountManagementAction implements Action {

	private AccountAdvancedMenu menu;

	@Autowired
	public OpenAccountManagementAction(AccountAdvancedMenu menu) {
		super();
		this.menu = menu;
	}

	public String getTitle() {
		return "Account Management";
	}


	public void execute() {
		menu.run();
	}
}
