package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("book")


public class Book extends Publication {


	@Column(name="isbn", unique=true) private String isbn;
	
	public Book(String isbn, String title){
		super(title);
		this.isbn = isbn;
	}
	
	public Book(){
		super();
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}




}
