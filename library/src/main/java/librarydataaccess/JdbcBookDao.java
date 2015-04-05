package librarydataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.BookDao;
import entities.Book;

public class JdbcBookDao implements BookDao{

	public JdbcBookDao(){
	
	} 
	
	public void registerBook(Book b){
		Connection con;
		Statement s;
		try{
			con = DatabaseConnection.createConnection();
			//s = con.createStatement();
		//	s.executeUpdate("INSERT INTO book(isbn, title) VALUES ("+b.getIsbn()+","+b.getTitle()+")");
		//	s.close();
			PreparedStatement ps = con.prepareStatement("INSERT INTO book(isbn, title) VALUES (?,?)");
			ps.setString(1, b.getIsbn());
			ps.setString(2, b.getTitle());
			ps.executeUpdate();
			ps.close();
			con.close();
		}catch (SQLException e){
			e.printStackTrace();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
		}
		
	}
	
	public  List<Book> listBook(){
		List<Book> books =  new ArrayList<Book>();
		try{
			Connection con = DatabaseConnection.createConnection();
			Statement s = con.createStatement();
			ResultSet resultSet = s.executeQuery("SELECT * FROM book");
			while (resultSet.next()) {
				Book b = new Book();
			    b.setId(resultSet.getInt("id"));
			    b.setIsbn(resultSet.getString("isbn"));
			    b.setTitle(resultSet.getString("title"));
			   books.add(b);
			}
			s.close();
			con.close();

		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return books;
	}
	
	
	public void updateBook(Book b){
		try{
			Connection con = DatabaseConnection.createConnection();
			PreparedStatement s = con.prepareStatement("UPDATE book SET isbn=?, title=? WHERE id=?");
			s.setString(1, b.getIsbn());
			s.setString(2, b.getTitle());
			s.setInt(3, b.getId());
			s.executeUpdate();
			s.close();
			con.close();
		}catch (SQLException e){
			e.printStackTrace();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
		}
	}
	
	public void deleteBook(int id){
		try{
			Connection con = DatabaseConnection.createConnection();
			Statement s = con.createStatement();
			s.executeUpdate("DELETE FROM book WHERE id="+id);
			s.close();
			con.close();
		}catch (SQLException e){
			e.printStackTrace();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
		}
	}
}
