package nate.menuadvanced;

import nate.menuadvanced.RegisterAccountOperation;
import nate.menuadvanced.UpdateAccountOperation;
import nate.menuadvanced.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountAdvancedMenu extends Menu{


	private RegisterAccountOperation registerOperation;
	private UpdateAccountOperation updateOperation;
	private InsertCardOperation cardOperation;
	private UpdateCardOperation updateCardOperation;
	private DeleteCardOperation deleteCardOperation;
	
	@Autowired
	public AccountAdvancedMenu(UIinterface ui, RegisterAccountOperation rao, UpdateAccountOperation uao,
			InsertCardOperation ico, UpdateCardOperation uco, DeleteCardOperation dco) {
		super(ui);
		this.registerOperation = rao;
		this.updateOperation = uao;
		this.cardOperation = ico;
		this.updateCardOperation = uco;
		this.deleteCardOperation = dco;
	}

	@Override
	public Operation[] getOperations() {
		Operation[] operations = { registerOperation, updateOperation, cardOperation, updateCardOperation, deleteCardOperation };
		return operations;
	}

}
