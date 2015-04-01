package librarydataaccess;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")


public class Book {

	@Id @GeneratedValue private int id;
	@Column(name="isbn", unique=true) private String isbn;
	@Column(name="title", length=50) private String title;
	
	public Book(String isbn, String title){
		this.isbn = isbn;
		this.title = title;
	}
	
	public Book(){
		
	}
	public void setId(int iD){
		id = iD;
	}
	public int getId(){
		return id;
	}
	public void setIsbn(String iSBN){
		isbn = iSBN;
	}
	public String getIsbn(){
		return isbn;
	}
	public void setTitle(String tITLE){
		title = tITLE;
	}
	public String getTitle(){
		return title;
	}
}
