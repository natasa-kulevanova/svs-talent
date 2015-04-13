package aliexpress.dao;

import java.util.List;

import aliexpress.entities.Product;

public interface WarehouseDao {

	public List<Product> listProducts();
	public int checkProduct(Product p);
	public void removeFromStock(Product p);
	public Product getProduct(Product p);
//	public Product getProductByName(String name);
	public void addProduct(Product p);
	public void deleteProduct(String name);
}
