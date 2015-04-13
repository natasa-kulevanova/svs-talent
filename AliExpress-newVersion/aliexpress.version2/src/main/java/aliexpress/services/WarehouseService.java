package aliexpress.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aliexpress.dao.WarehouseDao;
import aliexpress.entities.Product;

@Service
public class WarehouseService {

	WarehouseDao wareHouse;

	@Autowired
	public WarehouseService(WarehouseDao wh) {
		wareHouse = wh;
	}

	public List<Product> listProducts() {
		return wareHouse.listProducts();
	}

	public int checkProduct(Product p) {
		return wareHouse.checkProduct(p);
	}

	public void removeFromStock(Product p) {
		wareHouse.removeFromStock(p);
	}

	public Product getProduct(Product p) {
		return wareHouse.getProduct(p);
	}

	public void addProduct(Product p) {
		wareHouse.addProduct(p);
	}
	
	public void deleteProduct(String n){
		wareHouse.deleteProduct(n);
	}
	
}
