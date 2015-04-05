package menus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import librarydataaccess.HibernateLoanDao;
import services.LoanService;
import entities.Loan;

public class LoanMenu {

	static LoanService loanService = new LoanService(new HibernateLoanDao());
	
	public static void listLoans() {
		List<Loan> loans = loanService.listLoan();
		System.out.println("Full list of loans:");
		for (Loan l : loans) {		
			System.out.println("Loan id: " + l.getId());
			System.out.println("Loan member name: " + l.getMember());
			System.out.println("Loan publication title " + l.getPublication());	
			System.out.println("Loan start date: "+l.getStartDate());
			System.out.println("Loan end date: "+l.getEndDate());
		}
	}
	
	public static void registerLoan(Scanner loanIn) {
		System.err.println("register loan....");
		
		/*System.out.println("Enter member name");
		String name = loanIn.next();
		System.out.println("Enter publication title");
		String title = loanIn.nextLine();
		System.err.println("Enter end date: (ex. 04/05/2015)");
		String end = loanIn.next();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {		 
			Date endDate = formatter.parse(end); 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date startDate = new Date();*/
	}
	
	public static void deleteLoan(Scanner loanIn){
		System.out.println("delete loan...");
	}

	public static void updateLoan(Scanner loanIn){
		System.out.println("update loan...");
	}
}
