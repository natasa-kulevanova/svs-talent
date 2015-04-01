package librarydataaccess;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateBookDao implements BookDaoInterface{


	
	public void registerBook(String isbn, String title) {
		Session session = HibernateDatabaseConnection.getSessionfactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
		    Book book = new Book();
		    book.setIsbn(isbn);
		    book.setTitle(title);
		    session.save(book);
		    tx.commit();

			
		}catch(RuntimeException e){
			if (tx != null) { tx.rollback(); }
		    throw e;
		}
		finally {
		    session.close();
		}

	}
		
	
	public List<Book> listBook() {
		Session session = HibernateDatabaseConnection.getSessionfactory().openSession();
		List<Book> books;
		Transaction tx = null;
		try{
			String hql = "FROM Book";
			Query query = session.createQuery(hql);
			books =  query.list();
			return books;
		}
		catch(RuntimeException e){
			if (tx != null) { tx.rollback(); }
		    throw e;
		}
		finally {
		    session.close();
		}

	}

	public void updateBook(Book b) {
		Session session = HibernateDatabaseConnection.getSessionfactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String hql = "UPDATE Book set title = :title WHERE id = :book_id";
			Query query = session.createQuery(hql);
			query.setParameter("title", b.getTitle());
			query.setParameter("book_id", b.getId());
			int result = query.executeUpdate();
			tx.commit();
			System.out.println("Rows affected: " + result);

		}catch(RuntimeException e){
			if (tx != null) { tx.rollback(); }
		    throw e;
		}
		finally {
		    session.close();
		}

	}

	public void deleteBook(int id) {
		Session session = HibernateDatabaseConnection.getSessionfactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String hql = "DELETE FROM Book WHERE id = :book_id";
			Query query = session.createQuery(hql);
			query.setParameter("book_id", id);
			int result = query.executeUpdate();
			tx.commit();
			System.out.println("Rows affected: " + result);

		}catch(RuntimeException e){
			if (tx != null) { tx.rollback(); }
		    throw e;
		}
		finally {
		    session.close();
		}

	}

}
