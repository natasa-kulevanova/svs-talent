package librarydataaccess;

import java.util.List;



public interface BookDaoInterface {

	public void registerBook(String isbn, String title);
	public List<Book> listBook();
	public void updateBook(Book b);
	public void deleteBook(int id);
}
