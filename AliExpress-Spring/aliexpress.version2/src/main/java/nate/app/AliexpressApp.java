/*package nate.app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import nate.ali.HibernateDatabaseConnection;
import nate.ali.ProductParser;
import nate.dao.HibernateWarehouseDao;
import nate.entities.Product;
import nate.menu.AccountMenu;
import nate.menu.MenuMenu;
import nate.menu.ProductMenu;
import nate.services.WarehouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@EnableAutoConfiguration
@Configuration
@ComponentScan (basePackages = "nate")
public class AliexpressApp implements CommandLineRunner {

	static String str = "products.txt";
	static int choice;
	static int mainChoice;
	static WarehouseService warehouseService = new WarehouseService(new HibernateWarehouseDao());
	
	static Scanner in = new Scanner(System.in);

	@Autowired
	private MenuMenu menuM;
	
	public static void main(String[] args) {
	//	HibernateDatabaseConnection.createSessionFactory();
	//	boolean run = true;

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
		
		SpringApplication.run(AliexpressApp.class, args);
	}

	public void run(String... arg0) throws Exception {
		HibernateDatabaseConnection.createSessionFactory();
		menuM.run(in);
		HibernateDatabaseConnection.closeFac();
	}
*/
		
		
	
	/*
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

*/