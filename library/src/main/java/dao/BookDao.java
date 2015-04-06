package dao;

import java.util.List;

import entities.Book;



public interface BookDao {

	public void registerBook(Book b);
	public List<Book> listBook();
	public void updateBook(Book b);
	public void deleteBook(int id);
}
