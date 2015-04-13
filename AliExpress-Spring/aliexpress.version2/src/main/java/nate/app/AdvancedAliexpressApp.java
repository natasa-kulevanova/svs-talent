package nate.app;

import java.util.ArrayList;

import nate.ali.HibernateDatabaseConnection;
import nate.ali.ProductParser;
import nate.dao.HibernateWarehouseDao;
import nate.entities.Product;
import nate.menuadvanced.MainMenu;
import nate.services.WarehouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = "nate")
public class AdvancedAliexpressApp implements CommandLineRunner {

	
	@Autowired
	private MainMenu menu;
	@Autowired
	static WarehouseService warehouseService = new WarehouseService(new HibernateWarehouseDao());
	public static void main(String[] args) {
			
		
		SpringApplication.run(AdvancedAliexpressApp.class, args);
	}

	
	public void run(String... arg0) throws Exception {
		HibernateDatabaseConnection.createSessionFactory();
		if (warehouseService.listProducts().size() > 0) {
			System.out.println("Hibernate database is loaded!\n");
		} else {
			ArrayList<Product> products = ProductParser.readProducts();
			System.out.println(products.size());
			for (Product p : products) {
				warehouseService.addProduct(p);
			}
		}
		menu.run();
		HibernateDatabaseConnection.closeFac();
	}
}
