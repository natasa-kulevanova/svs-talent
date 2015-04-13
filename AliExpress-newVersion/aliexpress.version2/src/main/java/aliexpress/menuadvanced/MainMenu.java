package aliexpress.menuadvanced;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import aliexpress.menuadvanced.UIinterface;
import aliexpress.menuadvanced.OpenAccountManagementAction;
import aliexpress.menuadvanced.OpenShopAction;

@Component
public class MainMenu extends Menu {

	private OpenAccountManagementAction accountAction;
	private OpenShopAction shopAction;

	@Autowired
	public MainMenu(UIinterface ui, OpenAccountManagementAction accountAction,
			OpenShopAction shopAction) {
		super(ui);
		this.accountAction= accountAction;
		this.shopAction = shopAction;
	}

	@Override
	public Action[] getActions() {
		Action[] actions = { accountAction, shopAction };
		return actions;
	}
}
