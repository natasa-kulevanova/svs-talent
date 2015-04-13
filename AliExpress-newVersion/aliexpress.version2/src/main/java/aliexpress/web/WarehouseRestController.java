package aliexpress.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import aliexpress.entities.Product;
import aliexpress.services.WarehouseService;

@RestController()
@RequestMapping("/api/warehouse")
public class WarehouseRestController {

	private WarehouseService warehouseService;

	@Autowired
	public WarehouseRestController(WarehouseService warehouseService) {
		super();
		this.warehouseService = warehouseService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Product> listProducts() {
		return warehouseService.listProducts();
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
	public String deleteProduct(@PathVariable("name") String name) {
		warehouseService.deleteProduct(name);
		return "Success";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Product addProduct(@RequestBody Product product) {
		warehouseService.addProduct(product);
		return product;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product,
			@PathVariable("id") int id) {
		product.setId(id);
		warehouseService.removeFromStock(product);;
		return product;
	}
}
