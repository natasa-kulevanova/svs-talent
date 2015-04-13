package nate.menuadvanced;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductShopOperation implements Operation {

	private ProductAdvancedMenu menu;
	

	@Autowired
	public ProductShopOperation(ProductAdvancedMenu menu) {
		super();
		this.menu = menu;
	}

	
	public String getTitle() {
		return "Product management";
	}

	public void execute() {
		menu.run();
	}
}
