package nate.menuadvanced;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import nate.entities.Account;
import nate.entities.CreditCard;
import nate.services.AccountService;
import nate.services.CreditCardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCardOperation implements Operation {

	private UIinterface ui;
	private AccountService accountService;
	private CreditCardService cardService;

	@Autowired
	public InsertCardOperation(UIinterface ui, AccountService accountService, CreditCardService cs) {
		super();
		this.ui = ui;
		this.accountService = accountService;
		this.cardService = cs;
	}

	public String getTitle() {
		return "Add one or more credit cards";
	}

	@SuppressWarnings("unused")
	public void execute() {
		CreditCard card = new CreditCard();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		
		String email = ui.requestInput("Enter e-mail:");
		String password = ui.requestInput("Enter password:");

		Account account = accountService.getUserByEmail(email);

		ui.print("*** Adding credit cards to account: " + account.getName());

		int num = Integer.parseInt(ui.requestInput("How many cards will you register?"));
		for (int i = 1; i <= num; i++) {
			System.out.println("Card " + i + " registration...");
			card.setCardNumber(Long.parseLong(ui
					.requestInput("Enter card number:")));
			String date = ui.requestInput("Enter card expiration date: (dd/mm/yyyy)");
			try {
				card.setExpDate(formatter.parse(date));
				if (cardService.checkCreditCard(card)) {
					card.setAccount(account);
					cardService.registerCreditCard(card);
					ui.print("Successfully registered new credit card\n");
				} else {
					ui.print("Expiration date not valid !");
				}
			} catch (ParseException ex) {
				ex.printStackTrace();
			}

		}
	}

}