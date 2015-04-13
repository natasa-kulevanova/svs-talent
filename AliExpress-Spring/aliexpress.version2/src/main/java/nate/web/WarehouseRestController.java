/*package nate.web;

import java.util.List;

import nate.entities.Product;
import nate.services.WarehouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/warehouse")
public class WarehouseRestController {

	@Autowired
	WarehouseService ws;

	@RequestMapping(method = RequestMethod.GET)
	public List<Product> listProducts() {
		return ws.listProducts();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Product registerBook(@RequestBody Product product) {
		ws.addProduct(product);
		return product;
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody int quantity,
			@PathVariable("name") String name) {
		Product p = new Product();
		p.setName(name);
		p.setQuantity(quantity);
		int i = ws.checkProduct(p);
		if (i == 1) {
			ws.removeFromStock(p);
			p = ws.getProductByName(name);
		}
		return p;
	}

}*/