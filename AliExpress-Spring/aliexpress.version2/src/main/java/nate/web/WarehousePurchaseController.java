/*package nate.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import nate.ali.ShoppingCart;
import nate.entities.Account;
import nate.entities.Product;
import nate.entities.PurchaseOrder;
import nate.services.AccountService;
import nate.services.PurchaseOrderService;
import nate.services.WarehouseService;


@Controller
@SessionAttributes("cart")
@RequestMapping("/productpurchase")
public class WarehousePurchaseController {
	WarehouseService ws;
	AccountService as;
	PurchaseOrderService pos;

	@Autowired
	public WarehousePurchaseController(WarehouseService ws, AccountService as,
			PurchaseOrderService pos) {
		this.ws = ws;
		this.as = as;
		this.pos = pos;
	}

	@ModelAttribute("products")
	public List<Product> getProducts() {
		return ws.listProducts();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listProducts() {
		return "PurchaseOrder";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String setQuantity(@RequestParam("name") String name,
			@RequestParam("quantity") Integer quantity,
			@ModelAttribute("cart") ShoppingCart shoppingCart) {
		Product pr = new Product();
		pr.setName(name);
		pr.setQuantity(quantity);
		int i = ws.checkProduct(pr);
		if (i == 1) {

			final Product p = ws.getProductByName(name);
			p.setQuantity(quantity);
			shoppingCart.addToCart(p);
		} else {
		}
		return "PurchaseOrder";
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String checkOut(@RequestParam("email") String email,
			@RequestParam("password") String password,
			@ModelAttribute("cart") ShoppingCart shoppingCart) {
		if (shoppingCart.getProducts() == null) {
			//message for empty basket
		} else {
			Account a = as.getUserByEmail(email);
			if (a.getPassword() != password) {
				//message for wrong password
			} else {
				PurchaseOrder po = new PurchaseOrder();
				po.setAccount(a);
				Set<Product> products = new HashSet<Product>(shoppingCart.getProducts());
				po.setProducts(products);
				pos.registerPurchaseOrder(po);
			}
		}
		return "PurchaseOrder";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String addToCart(@ModelAttribute("product") Product product) {

		return "redirect:/productpurchase";
	}

}*/