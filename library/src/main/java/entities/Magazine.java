package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("magazine")

public class Magazine extends Publication {

	@Column(name="issn", unique=true) private String issn;
	
	public Magazine(String issn, String title){
		super(title);
		this.issn = issn;
	}
	
	public Magazine(){
		super();
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}
}
