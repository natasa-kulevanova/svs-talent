package nate.menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

import nate.dao.HibernateAccountDao;
import nate.dao.HibernateCreditCardDao;
import nate.entities.Account;
import nate.entities.CreditCard;
import nate.services.AccountService;
import nate.services.CreditCardService;
import nate.template.HibernateTemplate;

public class AccountMenu {

	private static CreditCardService cardService = new CreditCardService(new HibernateCreditCardDao(new HibernateTemplate()));
	private static AccountService accountService = new AccountService(new HibernateAccountDao(new HibernateTemplate()));	
	public static boolean loggedIn = false;
	
	public static void run(Scanner in) {
		Scanner sc = in;
		int input;
		boolean run = true;
		while(run){
			System.out.println("Enter a command: ");
			System.out.println("1. Register new account");
			System.out.println("2. Update account");
			System.out.println("3. Delete account");
			System.out.println("0. Return");
			
			try {
				input = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("You have to enter 1, 2, 3 or 0.");
				continue;
			}
			
			switch(input){
				case 1:{
					registerAccount(sc);
					break;
				}
				case 2:{
					updateAccount(sc);
					break;
				}
				case 3:{
					deleteAccount(sc);
					break;
				}
				case 0:{
					run = false;
					break;
				}
				default:{
					System.out.println("Invalid enter.");
					break;
				}
			}
		}
	}
	
	
	public static void registerAccount(Scanner sc){
		Account a = new Account();
		CreditCard card = new CreditCard();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println("Enter account name:");
		String n = sc.next();
		a.setName(n);
		System.out.println("Enter account email:");
		String e = sc.next();
		a.setEmail(e);
		System.out.println("Enter account password: ");
		a.setPassword(sc.next());
		accountService.registerAccount(a);
		System.out.println("How many cards will you register?");
		int num = sc.nextInt();
		for(int i = 1; i<=num; i++){
			System.out.println("Card "+i+" registration...");
			System.out.println("Enter card number: ");
			card.setCardNumber(sc.nextLong());
			System.out.println("Enter card expiration date: (dd/mm/yyyy)");
			String date = sc.next();
			try {
				//Date expDate = formatter.parse(date);
				card.setExpDate( formatter.parse(date));
			} catch (ParseException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}	
			card.setAccount(a);
			cardService.registerCreditCard(card);
		}
		
	}
	
	public static void updateAccount(Scanner sc){
		System.out.println("...Password update...\n");
		Account a = new Account();
		System.out.println("Enter your name: ");
		String name = sc.next();
		System.out.println("Enter your old password:");
		String pass = sc.next();
		if(accountService.checkAccount(name, pass)){
			System.out.println("Enter your new password:");
			String newPass = sc.next();
			a.setPassword(newPass);
			accountService.updateAccount(a);
			System.out.println("Success.");
		}
		else{
			System.out.println("Invalid account!");
		}
	
	}
	
	public static void deleteAccount(Scanner sc){
		System.out.println("...Delete account...\n");
		Account a = new Account();
		System.out.println("Enter your name: ");
		String name = sc.next();
		System.out.println("Enter your password:");
		String pass = sc.next();
		if(accountService.checkAccount(name, pass)){
			accountService.deleteAccount(a);
			System.out.println("Success.");
		}
		else{
			System.out.println("Invalid account!");
		}
	}
		
}
