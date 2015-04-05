package entities;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="publication")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)

public class Publication {

	@Id @GeneratedValue private int id;
	@Column(length=150) private String title;
	@OneToMany(mappedBy = "publication")
	private Set<Loan> loans;
	
	public Publication(){
		
	}
	
	public Publication(String title){
		this.title = title;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
