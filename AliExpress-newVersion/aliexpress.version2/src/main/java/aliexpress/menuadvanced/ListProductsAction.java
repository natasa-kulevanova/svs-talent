package aliexpress.menuadvanced;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aliexpress.entities.Product;
import aliexpress.services.WarehouseService;
import aliexpress.menuadvanced.UIinterface;

@Component
public class ListProductsAction implements Action {

	private WarehouseService warehouseService;
	private UIinterface ui;

	@Autowired
	public ListProductsAction(WarehouseService warehouseService, UIinterface ui) {
		super();
		this.warehouseService = warehouseService;
		this.ui = ui;
	}

	public String getTitle() {
		return "List Products";
	}

	
	public void execute() {
		List<Product> products = warehouseService.listProducts();
		for (Product product : products) {
			ui.print(product.toString());
		}
	}
}
