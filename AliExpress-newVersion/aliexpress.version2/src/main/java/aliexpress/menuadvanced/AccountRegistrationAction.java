package aliexpress.menuadvanced;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aliexpress.entities.Account;
import aliexpress.entities.CreditCard;
import aliexpress.services.AccountService;
import aliexpress.services.CreditCardService;


@Component
public class AccountRegistrationAction implements Action{

	
	private UIinterface ui;
	private AccountService accountService;
	private CreditCardService cardService;

	@Autowired
	public AccountRegistrationAction(UIinterface ui, AccountService accountService, CreditCardService cs) {
		super();
		this.ui = ui;
		this.accountService = accountService;
		this.cardService = cs;
	}

	
	
	public String getTitle() {
		return "Account Registration";
	}

	public void execute() {
		Account a = new Account();
		CreditCard card = new CreditCard();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		String n = ui.requestInput("Enter account name:");
		a.setName(n);
		String e = ui.requestInput("Enter account email:");
		a.setEmail(e);
		String pass = ui.requestInput("Enter account password: ");
		a.setPassword(pass);
		accountService.registerAccount(a);
		int num = Integer.parseInt(ui.requestInput("How many cards will you register?"));
		for(int i = 1; i<=num; i++){
			System.out.println("Card "+i+" registration...");
			card.setCardNumber(Long.parseLong(ui.requestInput("Enter card number:")));
			String date = ui.requestInput("Enter card expiration date: (dd/mm/yyyy)");
			try {
				card.setExpDate( formatter.parse(date));
			} catch (ParseException ex) {
				ex.printStackTrace();
			}	
			card.setAccount(a);
			cardService.registerCreditCard(card);
		}
		
	}

	
}
