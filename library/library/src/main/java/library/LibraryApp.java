package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {

	public static void main(String[] args){
		System.out.println("Welcome to The Library");
		boolean run = true;
		while(run){
			System.out.println("Enter 1 to see full list of books, 2 to register book, 3 to unregister book, 4 to update a book. Enter 0 to terminate.");
			Scanner in = new Scanner(System.in);
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
					run=false;
					break;	
				}
				default: System.out.println("Please enter a valid command."); break;
			}
		}
	
	}
	
	public static void listBooks(){
		ArrayList<Book> books = new ArrayList<Book>();
		books = LibraryService.getBooks();
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
		LibraryService.registerBook(isbn, title);
	}

	public static void unRegisterBook(){
		System.out.println("Enter book id");
		Scanner bookIn = new Scanner(System.in);
		int id = bookIn.nextInt();
		LibraryService.deleteBook(id);
	}
	
	public static void updateBook(){
		System.out.println("Enter the id of the book you want to update");
		Scanner bookIn = new Scanner(System.in);
		int id = bookIn.nextInt();
		System.out.println("Enter new isbn for the book");
		bookIn = new Scanner(System.in);
		String isbn = bookIn.nextLine();
		System.out.println("Enter new title for the book");
		bookIn = new Scanner(System.in);
		String title = bookIn.nextLine();
		Book b = new Book();
		b.setId(id);
		b.setIsbn(isbn);
		b.setTitle(title);
		LibraryService.updateBook(b);
	}
}