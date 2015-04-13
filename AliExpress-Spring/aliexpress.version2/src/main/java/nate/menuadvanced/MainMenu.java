package nate.menuadvanced;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainMenu extends Menu {

	private AccountManagementOperation accountOperation;
	private ProductShopOperation shopOperation;
	
	
	@Autowired
	public MainMenu(UIinterface ui, AccountManagementOperation amo,
			ProductShopOperation pso) {
		super(ui);
		this.accountOperation= amo;
		this.shopOperation = pso;
	}

	@Override
	public Operation[] getOperations() {
		Operation[] operations = { accountOperation, shopOperation };
		return operations;
	}
}
