package nate.dao;

import java.util.List;

import nate.entities.Product;

public interface WarehouseDao {

	public List<Product> listProducts();
	public int checkProduct(Product p);
	public void removeFromStock(Product p);
	public Product getProduct(Product p);
	public Product getProductByName(String name);
	public void addProduct(Product p);
	public void deleteProduct(String name);
	public void updateProduct(Product p);
}
