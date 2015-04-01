package services;

import java.util.List;


import librarydataaccess.Book;
import librarydataaccess.BookDaoInterface;

public class LibraryService {

	//static BookDaoInterface bookDao = new JdbcBookDao();
	//static BookDaoInterface bookDao = new HibernateBookDao();
	BookDaoInterface bookDao;
	public LibraryService(BookDaoInterface bookDao){
		this.bookDao = bookDao;
	}
	
	public List getBooks(){
		return bookDao.listBook();
	}
	
	public void registerBook(String isbn, String title){
		bookDao.registerBook(isbn, title);
	}
	
	public void deleteBook(int id){
		bookDao.deleteBook(id);
	}
	
	public void updateBook(Book b){
		bookDao.updateBook(b);
	}
}
