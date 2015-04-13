package aliexpress.menuadvanced;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aliexpress.ali.ShoppingCart;
import aliexpress.entities.Account;
import aliexpress.services.AccountService;
import aliexpress.services.WarehouseService;
import aliexpress.menuadvanced.UIinterface;

@Component
public class CheckoutAction implements Action{

	private UIinterface ui;
	private ShoppingCart basket;
	private AccountService accountService;
	private WarehouseService warehouseService;

	@Autowired
	public CheckoutAction(UIinterface ui, ShoppingCart basket, AccountService accountService,
			WarehouseService warehouseService) {
		super();
		this.ui = ui;
		this.basket = basket;
		this.accountService = accountService;
		this.warehouseService = warehouseService;
	}


	public String getTitle() {
		return "Checkout";
	}

	
	public void execute() {
		
		String email = ui.requestInput("e-mail:");
		String password = ui.requestInput("password");
		Account tmp = new Account();
		tmp.setEmail(email);
		tmp.setPassword(password);
		tmp = accountService.getUserByEmail(email); 
		if(tmp!=null){
			if(basket.shoppingList.isEmpty()){
				System.out.println("Empty!");
			}
			else {
				for(int i = 0; i < basket.shoppingList.size(); i++){
					System.out.println((basket.shoppingList.get(i).getName())+" quantity: "+(basket.shoppingList.get(i).getQuantity())+
							" price: "+basket.shoppingList.get(i).getPrice());
				}
				basket.totalPrice = basket.totalCost();
			}
			System.out.println("Total cost: "+basket.totalPrice+"$");
		}
	}
	
}



