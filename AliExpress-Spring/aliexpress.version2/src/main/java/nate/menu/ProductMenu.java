package nate.menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import nate.ali.ShoppingCart;
import nate.dao.HibernateWarehouseDao;
import nate.entities.Product;
import nate.services.WarehouseService;

public class ProductMenu {

	private static WarehouseService warehouseService = new WarehouseService(
			new HibernateWarehouseDao());
	private static ShoppingCart shoppingCart;

	
	public static void run(Scanner in) {
		
		Scanner sc = in;
		int input;
		boolean run = true;
		while (run) {
			System.out.println("Enter a command: ");
			System.out.println("1. Display full product list");
			System.out.println("2. Shop");
			System.out.println("3. Proceed check-out");
			System.out.println("0. Return");
			try {
				input = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("You have to enter 1, 2, 3 or 0.");
				continue;
			}
			switch (input) {
			case 1: {
				listProducts();
				break;
			}
			case 2: {
				shop(in);
				break;
			}
			case 3: {
				proceedCheckOut(in);
				break;
			}
			case 0: {
				run = false;
				break;
			}
			default: {
				System.out.println("You have to enter 1 or 0.");
				break;
			}
			}
		}
	}

	public static void listProducts() {
		System.out.println("\n---Full list of products---\n");
		ArrayList<Product> products = (ArrayList<Product>) warehouseService.listProducts();

		for (Product p : products) {
			System.out.println((products.indexOf(p)+1)+". Product_name: "+p.getName()+" | Price: "+p.getPrice());
		}
		System.out.println("\n");
	}

	@SuppressWarnings("unused")
	public static void shop(Scanner in) {
		int purchaseStatus = 0;
		System.out
				.println("Enter the name of the product that you want to purchase (example: Bag)");
		String productName = in.next();
		System.out
				.println("Enter the quantity of the product that you want to purchase (example: 2)");
		try {
			int productQuantity = in.nextInt();
			Product p = new Product();
			p.setName(productName);
			p.setQuantity(productQuantity);

			purchaseStatus = warehouseService.checkProduct(p);
			if (purchaseStatus == 1) {
				Product product = warehouseService.getProduct(p);
				shoppingCart.addToCart(p);
				System.out
						.println("New product has been added to your shopping basket ("
								+ productName + "|" + productQuantity + ")");
			} else if (purchaseStatus == 2) {
				System.out.println("Product name is not valid!");
			} else if (purchaseStatus == 3) {
				System.out
						.println("We dont have that much in stock. Try again with smaller quantity (or other product).");
			}
		} catch (InputMismatchException e) {
			System.out.println("Enter integer value for the quatity!!!");
		}

	}

	public static void proceedCheckOut(Scanner in) {
		if (shoppingCart.shoppingList.isEmpty()) {
			System.out.println("Empty!");
		} else {
			for (int i = 0; i < shoppingCart.shoppingList.size(); i++) {
				System.out.println((shoppingCart.shoppingList.get(i).getName())
						+ " quantity: "
						+ (shoppingCart.shoppingList.get(i).getQuantity())
						+ " price: "
						+ shoppingCart.shoppingList.get(i).getPrice());
			}
			shoppingCart.totalPrice = shoppingCart.totalCost();
		}
		System.out.println("Total cost: " + shoppingCart.totalPrice + "$");
	}
}
