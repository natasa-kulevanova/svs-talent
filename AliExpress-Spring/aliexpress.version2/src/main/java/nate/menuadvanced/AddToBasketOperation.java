package nate.menuadvanced;

import nate.ali.ShoppingCart;
import nate.entities.Product;
import nate.menuadvanced.UIinterface;
import nate.services.WarehouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddToBasketOperation implements Operation {

	private WarehouseService warehouseService;
	private UIinterface ui;
	private ShoppingCart basket;

	@Autowired
	public AddToBasketOperation(WarehouseService warehouseService,
			UIinterface ui, ShoppingCart basket) {
		super();
		this.warehouseService = warehouseService;
		this.ui = ui;
		this.basket = basket;
	}

	public String getTitle() {
		return "Add product to shopping cart";
	}

	public void execute() {
		String name = ui.requestInput("Enter product name: (example: Bag)");
		int quantity = Integer.parseInt(ui.requestInput("Enter product quantity: (example: 2)"));
		Product p = new Product();
		p.setName(name);
		p.setQuantity(quantity);
		
		//proverka dali vnesenite vrednosti za imeto i kolicinata se validni
		int s = warehouseService.checkProduct(p);
		
		if (s == 1) {
			Product pr = warehouseService.getProduct(p);
			basket.addToCart(p);
			warehouseService.removeFromStock(pr);
		} else if (s == 2) {
			System.out.println("Invalid product name!!!");
		} else {
			System.out.println("We don have that mush in stock. Try with smaller quantity or other product.");
		}

	}

}
