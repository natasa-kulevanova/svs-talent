package aliexpress;

public class Product {

	private int key;
	private String name;
	private int price;
	private int quantity;
	
	public Product(int k, String n, int p, int q){
		this.key = k;
		this.name = n;
		this.price = p;
		this.quantity = q;
	}
	
	public Product(){
		
	}
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
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

	
}
