package librarydataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DatabaseConnection {

	public static Connection createConnection(){
		 Connection con;
		try{
			return con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "library1!");
		} catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		
	}

}
