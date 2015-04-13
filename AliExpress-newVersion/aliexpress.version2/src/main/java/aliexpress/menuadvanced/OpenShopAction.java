package aliexpress.menuadvanced;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import aliexpress.menuadvanced.ProductAdvancedMenu;

@Component
public class OpenShopAction implements Action {

	private ProductAdvancedMenu menu;

	@Autowired
	public OpenShopAction(ProductAdvancedMenu menu) {
		super();
		this.menu = menu;
	}

	public String getTitle() {
		return "Shop";
	}

	public void execute() {
		menu.run();
	}
}
