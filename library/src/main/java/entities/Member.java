package entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Member {

	@Id
	@GeneratedValue
	private int id;
	@Column(length = 100)
	private String name;
	@Column(length = 120)
	private String email;
	@OneToMany(mappedBy = "member")
	private Set<Loan> loans;
	@OneToOne(mappedBy = "member")
	private Membership membership;

	public Member() {
	}

	public Member(String n, String e) {
		name = n;
		email = e;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
