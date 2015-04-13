package nate.menuadvanced;

import nate.ali.ShoppingCart;
import nate.entities.Account;
import nate.menuadvanced.UIinterface;
import nate.services.AccountService;
import nate.services.WarehouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckoutOperation implements Operation{

	private UIinterface ui;
	private ShoppingCart cart;
	private AccountService accountService;
	@Autowired
	private WarehouseService warehouseService;

	@Autowired
	public CheckoutOperation(UIinterface ui, ShoppingCart cart, AccountService accountService,
			WarehouseService warehouseService) {
		super();
		this.ui = ui;
		this.cart = cart;
		this.accountService = accountService;
		this.warehouseService = warehouseService;
	}


	public String getTitle() {
		return "Proceed to Checkout";
	}

	
	public void execute() {
		
		String email = ui.requestInput("Enter your e-mail:");
		String password = ui.requestInput("Enter your password:");
		Account tmp = new Account();
		tmp.setEmail(email);
		tmp.setPassword(password);
		tmp = accountService.getUserByEmail(email); 
		if(tmp!=null){
			if(cart.shoppingList.isEmpty()){
				System.out.println("Your shopping cart is empty!");
			}
			else {
				ui.print("******************");
				ui.print("Shopping cart for account: "+email+"\n");
				for(int i = 0; i < cart.shoppingList.size(); i++){
					ui.print((cart.shoppingList.get(i).getName())+" quantity: "+(cart.shoppingList.get(i).getQuantity())+
							" price: "+cart.shoppingList.get(i).getPrice());
				}
				cart.totalPrice = cart.totalCost();
			}
			System.out.println("\nTotal cost: "+cart.totalPrice+"$\n");
		}
	}
	
}



