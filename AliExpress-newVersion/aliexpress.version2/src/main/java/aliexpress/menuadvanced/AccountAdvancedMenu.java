package aliexpress.menuadvanced;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import aliexpress.menuadvanced.AccountRegistrationAction;
import aliexpress.menuadvanced.AccountUpdateAction;

@Component
public class AccountAdvancedMenu extends Menu{


	private AccountRegistrationAction regAction;
	private AccountUpdateAction updateAction;

	@Autowired
	public AccountAdvancedMenu(UIinterface ui, AccountRegistrationAction action1, AccountUpdateAction updateAction) {
		super(ui);
		this.regAction = action1;
		this.updateAction = updateAction;
	}

	@Override
	public Action[] getActions() {
		Action[] actions = { regAction, updateAction };
		return actions;
	}

}
