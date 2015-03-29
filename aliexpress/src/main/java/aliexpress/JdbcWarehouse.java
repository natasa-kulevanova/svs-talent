package aliexpress;


import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JdbcWarehouse implements WarehouseInterface {
	
	public ArrayList<Product> productList = new ArrayList<Product>();
	
	public JdbcWarehouse(){	
	}

	public int checkProduct(String name, int quantity) {
		int status = 0;
		try{
			Connection con = DatabaseConnection.createConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM product WHERE name=?");
			ps.setString(1, name);
			ResultSet resultSet = ps.executeQuery();
			if(!resultSet.next()){
				//product name not valid
				status = 2;
			}
			else{
				if(resultSet.getInt("quantity")>=quantity){
					//product name and quantity valid
					status = 1;
					removeFromStock(name, quantity);
				}
				else
					//product quantity not valid
					status = 3;
			}
			ps.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return status;
	}

	public void removeFromStock(String nameR, int quantityR) {
		try{
			Connection c = DatabaseConnection.createConnection();
			PreparedStatement ps = c.prepareStatement("UPDATE product SET quantity=quantity-? WHERE name=?");
			ps.setInt(1, quantityR);
			ps.setString(2, nameR);
			ps.executeUpdate();
			ps.close();
			c.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	public Product getProduct(String nameS, int quantityS) {
		Product product = new Product();
		try{
			Connection con = DatabaseConnection.createConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM product WHERE name= ? ");
			ps.setString(1, nameS);
			ResultSet resultSet = ps.executeQuery();
			resultSet.next();
			product.setKey(resultSet.getInt("key"));
			product.setName(resultSet.getString("name"));
			product.setPrice(resultSet.getInt("price"));
			product.setQuantity(quantityS);
			return product;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Product> listProducts() {
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			Connection con = DatabaseConnection.createConnection();
			PreparedStatement st = con.prepareStatement("SELECT * FROM product");
			ResultSet resultSet = st.executeQuery();
			if (resultSet.next())
				do {
					//show only products with quantity > 0
					if(resultSet.getInt("quantity")>0){
						Product p = new Product();
						p.setKey(resultSet.getInt("key"));
						p.setName(resultSet.getString("name"));
						p.setPrice(resultSet.getInt("price"));
						p.setQuantity(resultSet.getInt("quantity"));
						products.add(p);
					}
				} while (resultSet.next());
			else
				return null;
			st.close();
			con.close();
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addProduct(Product product) {
		try {
			Connection con = DatabaseConnection.createConnection();
			PreparedStatement st = con.prepareStatement("INSERT INTO product(key, name, price, quantity) VALUES (?, ?, ?, ?)");
			st.setInt(1, product.getKey());
			st.setString(2, product.getName());
			st.setInt(3, product.getPrice());
			st.setInt(4, product.getQuantity());
			st.executeUpdate();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
