package entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Membership {

	@Id
	@GeneratedValue
	private int id;
	@Column(name = "enddate")
	private Date endDate;
	@Column(name = "memershiptype")
	private String memeberType;
	@Column(name = "startdate")
	private Date startDate;
	@OneToOne
	private Member member;

	public Membership() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getMemeberType() {
		return memeberType;
	}

	public void setMemeberType(String memeberType) {
		this.memeberType = memeberType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
