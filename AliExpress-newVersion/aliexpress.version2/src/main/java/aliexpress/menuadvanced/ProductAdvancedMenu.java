package aliexpress.menuadvanced;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aliexpress.menuadvanced.UIinterface;
import aliexpress.menuadvanced.ListProductsAction;
import aliexpress.menuadvanced.AddProductToBasketAction;
import aliexpress.menuadvanced.CheckoutAction;

@Component
public class ProductAdvancedMenu extends Menu{

	private ListProductsAction listAction;
	private AddProductToBasketAction addToBasketAction;
	private CheckoutAction checkOutAction;
	
	@Autowired
	public ProductAdvancedMenu(UIinterface ui, ListProductsAction listAction,
			AddProductToBasketAction addToBasketAction, CheckoutAction checkOutAction) {
		super(ui);
		this.listAction = listAction;
		this.addToBasketAction = addToBasketAction;
		this.checkOutAction = checkOutAction;
	}

	
	public Action[] getActions() {
		Action[] actions = { listAction, addToBasketAction, checkOutAction };
		return actions;
	}

}
