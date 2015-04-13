package aliexpress.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import aliexpress.ali.HibernateDatabaseConnection;
import aliexpress.menuadvanced.MainMenu;


@EnableAutoConfiguration
@Configuration
@ComponentScan
public class AdvancedAliexpressApp implements CommandLineRunner {

	@Autowired
	private MainMenu menu;

	public static void main(String[] args) {
		SpringApplication.run(AdvancedAliexpressApp.class, args);
	}

	
	public void run(String... arg0) throws Exception {
		HibernateDatabaseConnection.createSessionFactory();
		menu.run();
		HibernateDatabaseConnection.closeFac();
	}
}
