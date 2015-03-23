import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class WareHouse {

	public ArrayList<Product> productList = new ArrayList<Product>();
	
	public WareHouse(String str){
		productList = ProductParser.readProducts(str);
	}
	
	//checks if name and quantity of the product are valid
	public int checkProduct(String name, int quantity){
		int status = 0;
		for(int p = 0; p < productList.size(); p++){
			if(productList.get(p).name.equals(name))
			{
				if(productList.get(p).quantity >= quantity){
					//product name and quantity are valid
					//purchase is performed
					 status = 1;
					 removeFromStock(name, quantity);
					 break;
				}
				else if(productList.get(p).quantity < quantity){
					//product quantity not valid
					status = 3;
					break;
				}
			}
			else {
				//product name not valid
				status =  2;
			}
		}
		return status;
	}
	//removes a purchased product from stock
	public void removeFromStock(String nameR, int quantityR){
		for(int i = 0; i < productList.size(); i++){
			if(productList.get(i).name.equals(nameR)){
				productList.get(i).quantity-=quantityR;
			}
		}
	}
	
	//returns the purchased product that needs to be added to shoppingCart
	public Product getProduct(String nameS, int quantityS){
		Product product = null;
		for(Product p : productList){
			if(p.name.equals(nameS)){
				product = new Product(p.key, nameS, p.price, quantityS);
				return product;
			}
		}
		return null;
	}
	
}
