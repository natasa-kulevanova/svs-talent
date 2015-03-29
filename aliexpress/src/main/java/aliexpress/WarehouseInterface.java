package aliexpress;

import java.util.ArrayList;

public interface WarehouseInterface {

	public ArrayList<Product> listProducts();
	public int checkProduct(String name, int quantity);
	public void removeFromStock(String nameR, int quantityR);
	public Product getProduct(String nameS, int quantityS);
	public void addProduct(Product product);
}
