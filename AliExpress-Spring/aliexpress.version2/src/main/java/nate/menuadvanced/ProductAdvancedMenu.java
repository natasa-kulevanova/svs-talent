package nate.menuadvanced;

import nate.menuadvanced.AddToBasketOperation;
import nate.menuadvanced.CheckoutOperation;
import nate.menuadvanced.ListProductsOperation;
import nate.menuadvanced.UIinterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductAdvancedMenu extends Menu{

	private ListProductsOperation listOperation;
	private AddToBasketOperation addToBasketOperation;
	private CheckoutOperation checkOutOperation;

	
	@Autowired
	public ProductAdvancedMenu(UIinterface ui, ListProductsOperation lpo,
			AddToBasketOperation atbo, CheckoutOperation co) {
		super(ui);
		this.listOperation = lpo;
		this.addToBasketOperation = atbo;
		this.checkOutOperation = co;
	}

	
	public Operation[] getOperations() {
		Operation[] operations= { listOperation, addToBasketOperation, checkOutOperation };
		return operations;
	}

}
