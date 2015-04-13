package nate.menuadvanced;

import java.util.List;

import nate.entities.Product;
import nate.menuadvanced.UIinterface;
import nate.services.WarehouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListProductsOperation implements Operation {

	private WarehouseService warehouseService;
	private UIinterface ui;

	@Autowired
	public ListProductsOperation(WarehouseService warehouseService, UIinterface ui) {
		super();
		this.warehouseService = warehouseService;
		this.ui = ui;
	}

	public String getTitle() {
		return "Full list of products";
	}

	
	public void execute() {
		int i = 1;
		List<Product> products = warehouseService.listProducts();
		for (Product product : products) {
			ui.print((i++)+" - Product name: "+product.getName()+" | Price: "+product.getPrice());
			
		}
		ui.print("");
	}
}
