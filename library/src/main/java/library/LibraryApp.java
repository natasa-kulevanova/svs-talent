package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import librarydataaccess.Book;
import librarydataaccess.HibernateBookDao;
import librarydataaccess.HibernateDatabaseConnection;
import services.LibraryService;

public class LibraryApp {

	static LibraryService libraryService = new LibraryService(new HibernateBookDao());
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args){
		HibernateDatabaseConnection.createSessionFactory();
		System.out.println("Welcome to The Library");
		boolean run = true;
		
		while(run){
			System.out.println("Enter 1 to see full list of books, 2 to register book, 3 to unregister book, 4 to update a book. Enter 0 to terminate.");
			
			int choice = in.nextInt();
			switch(choice){
				case 1:{ 
					listBooks();
					break;
				}
				case 2: {
					insertBook();
					break;
				}
				case 3:{
					unRegisterBook();
					break;
				}
				case 4:{
					updateBook();
					break;
				}
				case 0:{
					System.out.println("Goodbye.");
					HibernateDatabaseConnection.closeFac();
					in.close();
					run=false;
					break;	
				}
				default: System.out.println("Please enter a valid command."); break;
			}
		}
	
	}
	
	/*
		nov scanner ima vo insert i update fikciite bidejki dokolku imeto na knigata
		se sostoi od 2 ili poveke zbora frlase InputMissMatchException, a vo
		bazata go zapisuvase samo prviot zbor
		
	*/
	 
	public static void listBooks(){
		List<Book> books = libraryService.getBooks();
		System.out.println("Full list of books:");
		for(Book b : books){
			System.out.println("Book id: "+b.getId());
			System.out.println("Book isbn: "+b.getIsbn());
			System.out.println("Book title: "+b.getTitle());
		}
	}
	
	public static void insertBook(){
		System.out.println("Enter book isbn");
		Scanner bookIn = new Scanner(System.in);
		String isbn = bookIn.nextLine();
		System.out.println("Enter book title");
		String title = bookIn.nextLine();
		libraryService.registerBook(isbn, title);
	}

	public static void unRegisterBook(){
		System.out.println("Enter book id");
		Scanner bookIn = new Scanner(System.in);
		int id = bookIn.nextInt();
		libraryService.deleteBook(id);
	}
	
	//ne go update-uva isbn-ot! Zosto?!
	//vo string title=bookIn2.next(); go zapisuva samo prviot zbor, a so nextLine() ne raboti!!!!!
	//ako se inicijalizira scanner-ot pak, go zapisuva celoto ime na knigata, a isbn ne go menuva!
	public static void updateBook(){
		System.out.println("Enter the id of the book you want to update");
		Scanner bookIn2 = new Scanner(System.in);
		int id = bookIn2.nextInt();
		System.out.println("Enter new isbn for the book");
		bookIn2 = new Scanner(System.in);
		String isbn = bookIn2.next();
		System.out.println("Enter new title for the book");
		bookIn2 = new Scanner(System.in);
		String title = bookIn2.nextLine();
		Book b = new Book();
		b.setId(id);
		b.setIsbn(isbn);
		b.setTitle(title);
		libraryService.updateBook(b);
	}
}