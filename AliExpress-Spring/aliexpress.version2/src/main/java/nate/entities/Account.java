package nate.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("user")
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue
	private int id;
	@Column(unique = true)
	private String email;
	@Column
	private String password;
	@Column
	private String name;
	@OneToMany(mappedBy = "account")
	private Set<CreditCard> cards;
	@OneToMany(mappedBy = "account")
	private Set<PurchaseOrder> orders;
	
	public Account(String name, String email, String password, Set<CreditCard> creditcards) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.cards = creditcards;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<CreditCard> getCards() {
		return cards;
	}

	public void setCards(Set<CreditCard> cards) {
		this.cards = cards;
	}

}
