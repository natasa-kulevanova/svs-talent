package aliexpress.entities;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue
	private int id;
	@Column(length = 50)
	private String name;
	@Column
	private int price;
	@Column
	private int quantity;
	/*@ManyToMany(mappedBy = "product")
	private Set<PurchaseOrder> orders;*/

	public Product() {
	}

	public Product(int id, String name, int price, int quantity) {
		this.id = id;
		this.setName(name);
		this.setPrice(price);
		this.setQuantity(quantity);
	}

	public Product(Product p) {
		this.id = p.id;
		this.name = p.getName();
		this.quantity = p.getQuantity();
		this.price = p.getPrice();
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/*public Set<PurchaseOrder> getOrders() {
		return orders;
	}

	public void setOrders(Set<PurchaseOrder> orders) {
		this.orders = orders;
	}*/

}
