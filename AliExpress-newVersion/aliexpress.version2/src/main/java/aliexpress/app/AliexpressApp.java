package aliexpress.app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import aliexpress.ali.HibernateDatabaseConnection;
import aliexpress.ali.ProductParser;
import aliexpress.dao.HibernateWarehouseDao;
import aliexpress.entities.Product;
import aliexpress.menu.AccountMenu;
import aliexpress.menu.ProductMenu;
import aliexpress.services.WarehouseService;

public class AliexpressApp {

	static String str = "products.txt";
	static int choice;
	static int mainChoice;
	static WarehouseService warehouseService = new WarehouseService(new HibernateWarehouseDao());
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		HibernateDatabaseConnection.createSessionFactory();
		boolean run = true;

		System.out.println("Hardcoded to work with hibernate!\n");

		if (warehouseService.listProducts().size() > 0) {
			System.out.println("Hibernate database is loaded!\n");
		} else {
			ArrayList<Product> products = ProductParser.readProducts();
			System.out.println(products.size());
			for (Product p : products) {
				warehouseService.addProduct(p);
			}
		}

		while (run) {
			System.out.println("Enter a command:");
			System.out.println("1. Account management");
			System.out.println("2. Product management");
			System.out.println("0. To terminate");

			try {
				choice = in.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid enter!!! Try again.");
			}

			switch (choice) {

			case 1: {
				AccountMenu.run(in);
				break;
			}

			case 2: {
				ProductMenu.run(in);
				break;
			}

			case 0: {
				System.out.println("Goodbye!!!");
				run = false;
				HibernateDatabaseConnection.closeFac();
				break;
			}

			default: {
				System.out.println("Invalid enter!!! Enter 1, 2, 3 or 0.");
			}
			}
		}
	}
}
