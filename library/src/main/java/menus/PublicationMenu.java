package menus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import librarydataaccess.HibernatePublicationDao;
import services.PublicationService;
import entities.Book;
import entities.Magazine;
import entities.Publication;

public class PublicationMenu {

	static PublicationService libraryService = new PublicationService(
			new HibernatePublicationDao());

	static InputStreamReader inp = new InputStreamReader(System.in);
	static BufferedReader buff = new BufferedReader(inp);

	public static void listBooks() {
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

	public static void insertBook(Scanner bookIn) {
		System.out.println("Enter 1 to register book, enter 2 to register magazine");
		int in = bookIn.nextInt();
		Publication p = null;
		if (in == 1) {
			try {
				System.out.println("Enter book isbn:");
				String isbn = buff.readLine();
				System.out.println("Enter book title:");
				String title = buff.readLine();
				p = new Book(isbn, title);
			} catch (Exception e) {
				System.out.println("Something went wrong.");
			}
		} else {
			try {
				System.out.println("Enter magazine issn:");
				String issn = buff.readLine();
				System.out.println("Enter magazine title:");
				String title = buff.readLine();
				p = new Magazine(issn, title);
			} catch (Exception e) {
				System.out.println("Something went wrong.");
			}
		}

		libraryService.registerPublication(p);
		
	}

	public static void unRegisterBook(Scanner bookIn) {
		System.out.println("Enter publication id:");
		int id = bookIn.nextInt();
		libraryService.deletePublication(id);
	}


	public static void updateBook(Scanner bookIn) {
		Publication p = new Publication();
		System.out
				.println("Enter 1 to update book, enter 2 to update magazine");
		int c = bookIn.nextInt();		
		if (c == 1) {
			System.out.println("Enter the id of the book you want to update:");
			int id = bookIn.nextInt();
			System.out.println("Enter new isbn for the book:");
			String isbn = bookIn.next();
			System.out.println("Enter new title for the book:");
			String title = bookIn.next();
			p.setId(id);
			//ClassCastException !!!!!
			((Book) p).setIsbn(isbn);
			p.setTitle(title);
			
		} else {
			System.out.println("Enter the id of the magazine you want to update:");
			int id = bookIn.nextInt();
			System.out.println("Enter new issn for the magazine:");
			String issn = bookIn.next();
			System.out.println("Enter new title for the magazine:");
			String title = bookIn.next();
			p.setId(id);
			//ClassCastException !!!!!
			((Magazine) p).setIssn(issn);
			p.setTitle(title);
			
		}
		libraryService.updatePublication(p);
	}

}
