package aliexpress.entities;


import javax.persistence.*;
import org.hibernate.mapping.Set;

@Entity
@Table(name = "purchaseorder")
public class PurchaseOrder {

	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	private Account account;
	//@ManyToMany
	//@JoinTable(name="purchase_product", joinColumns=@JoinColumn(name = "purchaseorder_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	@Column
	private Set products;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Set getProducts() {
		return products;
	}

	public void setProducts(Set products) {
		this.products = products;
	}

}
