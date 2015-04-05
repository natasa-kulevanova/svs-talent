package entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loan")
public class Loan {

	@Id
	@GeneratedValue
	private int id;
	@Column(name = "startdate")
	private Date startDate;
	@Column(name = "enddate")
	private Date endDate;
	@ManyToOne
	private Member member;
	@ManyToOne
	private Publication publication;

	public Loan() {
	}
	
	public Loan(Date s, Date e, Member m, Publication p){
		startDate = s;
		endDate = e;
		member = m;
		publication = p;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

}
