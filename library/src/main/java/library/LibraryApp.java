package library;


import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Loan;
import librarydataaccess.HibernateDatabaseConnection;
import librarydataaccess.HibernateMemberDao;
import librarydataaccess.HibernatePublicationDao;
import menus.LoanMenu;
import menus.MemberMenu;
import menus.PublicationMenu;
import services.MemberService;
import services.PublicationService;

public class LibraryApp {

	static PublicationService libraryService = new PublicationService(
			new HibernatePublicationDao());
	static MemberService memberService = new MemberService(new HibernateMemberDao());
	static Scanner in = new Scanner(System.in);
	static int choice;

	public static void main(String[] args) {
		HibernateDatabaseConnection.createSessionFactory();
		System.out.println("Welcome to The Library");
		boolean run = true;
		boolean execute = true;
		
	
		while (execute) {
			System.out.println("Enter: 1-library management, 2-membering, 3-loaning, 0-to terminate");

			try {
				choice = in.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid enter.");
			}
			
			switch (choice) {
			case 1: {
				//publicationMenu
				run = true;
				while (run) {
					
					System.out.println("--------------------------------");
					System.out.println("Enter a command:");
					System.out.println(" 1. Full list of publications"
							+"\n 2. Register new publication"
							+"\n 3. Delete publication"
							+"\n 4. Update publication"
							+"\n 0. Back to main menu");
					System.out.println("--------------------------------");
					
					choice = in.nextInt();
					switch (choice) {
					case 1: { 
						PublicationMenu.listBooks();
						break;
					}
					case 2: {
						PublicationMenu.insertBook(in);
						break;
					}
					case 3: {
						PublicationMenu.unRegisterBook(in);
						break;
					}
					case 4: {
						PublicationMenu.updateBook(in);
						break;
					}
					case 0: {
						run = false;
						break;
					}
					default:
						System.out.println("Please enter a valid command.");
						break;
					}
				}
				break;
			}
			//memberingMenu
			case 2: {
				run = true;
				while (run) {
					System.out.println("---------------------------");
					System.out.println("Enter a command:");
					System.out.println("\n1. Full list of members"
							+"\n2. Register new member"
							+"\n3. Delete member"
							+"\n4. Update member"
							+"\n0. Back to main menu");
					System.out.println("--------------------------------");
					
					choice = in.nextInt();
					switch (choice) {
					case 1: {
						MemberMenu.listMember();
						break;
					}
					case 2: {
						MemberMenu.registerMember(in);
						break;
					}
					case 3: {
						MemberMenu.deleteMember(in);
						break;
					}
					case 4: {
						MemberMenu.updateMember(in);
						break;
					}
					case 0: {
						run = false;
						break;
					}
					default:
						System.out.println("Please enter a valid command.");
						break;
					}
				}
					break;	
			}
			//loanMenu
			case 3: {
				run = true;
				while (run) {
					System.out.println("--------------------------------");
					System.out.println("Enter a command:");
					System.out.println("\n1. Full list of loans"
							+"\n2. Register new loann"
							+"\n3. Delete loan"
							+"\n4. Update loan"
							+"\n0. Back to main menu");
					System.out.println("--------------------------------");
					
					choice = in.nextInt();
					switch (choice) {
					case 1: {
						LoanMenu.listLoans();
						break;
					}
					case 2: {
						LoanMenu.registerLoan(in);
						break;
					}
					case 3: {
						LoanMenu.deleteLoan(in);
						break;
					}
					case 4: {
						LoanMenu.updateLoan(in);
						break;
					}
					case 0: {
						run = false;
						break;
					}
					default:
						System.out.println("Please enter a valid command.");
						break;
					}
				}
					break;
			}
			//system exit...bye bye
			case 0: {
				System.out.println("Goodbye.");
				HibernateDatabaseConnection.closeFac();
				in.close();
				execute = false;
				break;
			}
			default: {
				System.out.println("Please enter a valid command.");
				break;
			}
			}

		}

	}

	/*
	 * nov scanner ima vo insert i update fikciite bidejki dokolku imeto na
	 * knigata se sostoi od 2 ili poveke zbora frlase InputMissMatchException, a
	 * vo bazata go zapisuvase samo prviot zbor
	 */

	/*public static void listBooks() {
		List<Publication> publications = libraryService.getPublications();
		System.out.println("Full list of books:");
		for (Publication p : publications) {
			if (p instanceof Book) {
				System.out.println("Book id: " + p.getId());
				System.out.println("Book isbn: " + ((Book) p).getIsbn());
				System.out.println("Book title: " + p.getTitle());
			} else {
				System.out.println("Magazine id: " + p.getId());
				System.out.println("Magazine issn: " + ((Magazine) p).getIssn());
				System.out.println("Magazine title: " + p.getTitle());
			}
		}
	}

	public static void insertBook() {
		System.out
				.println("Enter 1 to register book, enter 2 to register magazine");
		Scanner bookIn = new Scanner(System.in);
		int in = bookIn.nextInt();
		Publication p;
		if (in == 1) {
			System.out.println("Enter book isbn");
			String isbn = bookIn.next();
			System.out.println("Enter book title");
			String title = bookIn.nextLine();
			p = new Book(isbn, title);
		} else {
			System.out.println("Enter magazine issn");
			String issn = bookIn.nextLine();
			System.out.println("Enter magazine title");
			String title = bookIn.nextLine();
			p = new Magazine(issn, title);
		}
		libraryService.registerPublication(p);
		bookIn.close();
	}

	public static void unRegisterBook() {
		System.out.println("Enter book id");
		Scanner bookIn = new Scanner(System.in);
		int id = bookIn.nextInt();
		libraryService.deletePublication(id);
		bookIn.close();
	}

	// ne go update-uva isbn-ot! Zosto?!
	// vo string title=bookIn2.next(); go zapisuva samo prviot zbor, a so
	// nextLine() ne raboti!!!!!
	// ako se inicijalizira scanner-ot pak, go zapisuva celoto ime na knigata, a
	// isbn ne go menuva!
	public static void updateBook() {
		Publication p = new Publication();
		System.out.println("Enter 1 to update book, enter 2 to update magazine");
		Scanner bookIn2 = new Scanner(System.in);
		int c = bookIn2.nextInt();
		if(c==1){
			System.out.println("Enter the id of the book you want to update");
			int id = bookIn2.nextInt();
			System.out.println("Enter new isbn for the book");
			String isbn = bookIn2.next();
			System.out.println("Enter new title for the book");
			String title = bookIn2.nextLine();
			p.setId(id);
			((Book)p).setIsbn(isbn);
			p.setTitle(title);
		}
		else{
			System.out.println("Enter the id of the magazine you want to update");
			int id = bookIn2.nextInt();
			System.out.println("Enter new issn for the magazine");
			String issn = bookIn2.next();
			System.out.println("Enter new title for the magazine");
			String title = bookIn2.nextLine();
			p.setId(id);
			((Magazine)p).setIssn(issn);
			p.setTitle(title);
		}
		libraryService.updatePublication(p);
		bookIn2.close();
	}
	
	*/
	// -------------------------------------------
	//----- MEMBER MANAGEMENT -----
	
	/*public static void listMember() {
		List<Member> members = memberService.listMember();
		System.out.println("Full list of books:");
		for (Member m : members) {		
			System.out.println("Member id: " + m.getId());
			System.out.println("Member name: " + m.getName());
			System.out.println("Member e-mail: " + m.getEmail());	
		}
	}
	
	public static void insertMember() {	
		Scanner memIn = new Scanner(System.in);	
		System.out.println("Enter member name");
		String name = memIn.next();
		System.out.println("Enter member e-mail");
		String email = memIn.nextLine();
		Member m = new Member(name, email);
		memberService.registerMember(m);
		memIn.close();
	}
	
	public static void updateMember(){
		Scanner memIn = new Scanner(System.in);	
		System.out.println("Enter the id of the member that you want to update");
		int id = memIn.nextInt();
		System.out.println("Enter new member name");
		String name = memIn.next();
		System.out.println("Enter new member e-mail");
		String email = memIn.nextLine();
		Member m = new Member();
		m.setId(id);
		m.setName(name);
		m.setEmail(email);
		memberService.updateMember(m);
		memIn.close();
	}
	
	public static void deleteMember(){
		Scanner memIn = new Scanner(System.in);	
		System.out.println("Enter member id");
		int id = memIn.nextInt();
		memberService.deleteMember(id);
		memIn.close();
	}*/
	
}