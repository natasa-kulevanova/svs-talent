package aliexpress.menuadvanced;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aliexpress.ali.ShoppingCart;
import aliexpress.entities.Product;
import aliexpress.services.WarehouseService;
import aliexpress.menuadvanced.UIinterface;

@Component
public class AddProductToBasketAction implements Action {

	private WarehouseService warehouseService;
	private UIinterface ui;
	private ShoppingCart basket;


	@Autowired
	public AddProductToBasketAction(WarehouseService warehouseService, UIinterface ui, ShoppingCart basket) {
		super();
		this.warehouseService = warehouseService;
		this.ui = ui;
		this.basket = basket;
	}


	public String getTitle() {
		return "Add product to basket";
	}


	public void execute() {
		String name = ui.requestInput("Enter product name:");
		int quantity = Integer.parseInt(ui.requestInput("Enter product quantity:"));
		Product tmp = new Product();
		tmp.setName(name);
		tmp.setQuantity(quantity);
		Product p = warehouseService.getProduct(tmp);
		basket.addToCart(p);
		
	}

}
