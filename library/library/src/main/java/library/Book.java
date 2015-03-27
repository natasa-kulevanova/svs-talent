package library;

public class Book {

	private int id;
	private String isbn;
	private String title;
	
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
