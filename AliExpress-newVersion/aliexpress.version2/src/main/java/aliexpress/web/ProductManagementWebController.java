package aliexpress.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aliexpress.entities.Product;
import aliexpress.services.WarehouseService;

@Controller
@RequestMapping("/products")
public class ProductManagementWebController {

	private WarehouseService warehouseService;

	@Autowired
	public ProductManagementWebController(WarehouseService warehouseService) {
		this.warehouseService = warehouseService;
	}

	@ModelAttribute("products")
	public List<Product> getProducts() {
		return warehouseService.listProducts();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listProducts() {
		return "ProductManagement";
	}

}
