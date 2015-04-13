package nate.menuadvanced;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import nate.entities.Account;
import nate.entities.CreditCard;
import nate.services.AccountService;
import nate.services.CreditCardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCardOperation implements Operation {

	private UIinterface ui;
	private AccountService accountService;
	private CreditCardService cardService;

	@Autowired
	public UpdateCardOperation(UIinterface ui, AccountService accountService, CreditCardService cs) {
		super();
		this.ui = ui;
		this.accountService = accountService;
		this.cardService = cs;
	}

	public String getTitle() {
		return "Update credit card";
	}

	@SuppressWarnings("unused")
	public void execute() {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		
		String email = ui.requestInput("Enter e-mail:");
		String password = ui.requestInput("Enter password:");

		Account account = accountService.getUserByEmail(email);

		String cardNumber = ui.requestInput("Enter credit card number to update: ");
		CreditCard card = cardService.getCardByNumber(Long.parseLong(cardNumber));
		
		ui.print("*** Updating credit card with cardNumber: " + cardNumber+"\n");
		String date = ui.requestInput("Enter new value for card expiration date: ");
		try {
			Date newDate = formatter.parse(date);
			card.setExpDate(newDate);
			cardService.updateCreditCard(card);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}