package nate.menuadvanced;

import java.text.SimpleDateFormat;

import nate.entities.Account;
import nate.entities.CreditCard;
import nate.services.AccountService;
import nate.services.CreditCardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCardOperation implements Operation {

	private UIinterface ui;
	private AccountService accountService;
	private CreditCardService cardService;

	@Autowired
	public DeleteCardOperation(UIinterface ui, AccountService accountService,
			CreditCardService cs) {
		super();
		this.ui = ui;
		this.accountService = accountService;
		this.cardService = cs;
	}

	public String getTitle() {
		return "Delete credit card";
	}

	@SuppressWarnings("unused")
	public void execute() {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");

		String email = ui.requestInput("Enter e-mail:");
		String password = ui.requestInput("Enter password:");

		Account account = accountService.getUserByEmail(email);
		if(accountService.checkAccount(account.getName(), email))
		{
			String cardNumber = ui.requestInput("Enter credit card number to delete: ");
			CreditCard card = cardService.getCardByNumber(Long.parseLong(cardNumber));
			cardService.deleteCreditCard(card);
			ui.print("Successfully deleted credit card with number: " + cardNumber+"\n");
		}
		else{
			ui.print("Invalid account email or password!!!");
		}
	}

}
