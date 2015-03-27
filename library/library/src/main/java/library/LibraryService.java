package library;

import java.util.ArrayList;

public class LibraryService {

	public static ArrayList<Book> getBooks(){
		return BookDao.listBook();
	}
	
	public static void registerBook(String isbn, String title){
		BookDao.registerBook(isbn, title);
	}
	
	public static void deleteBook(int id){
		BookDao.deleteBook(id);
	}
	
	public static void updateBook(Book b){
		BookDao.updateBook(b);
	}
}
