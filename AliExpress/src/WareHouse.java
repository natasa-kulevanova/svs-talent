import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class WareHouse {

	public ArrayList<Product> productList = new ArrayList<Product>();
	
	public WareHouse(String str){
		StringTokenizer st;
		try{
			FileReader file = new FileReader(str);
			BufferedReader buff = new BufferedReader(file);
			boolean eof = false;
			while(!eof){
				String line = buff.readLine();
				if(line == null){
					eof = true;
				}
				else{
					st = new StringTokenizer(line, "|");
					String key = st.nextToken();
					String name = st.nextToken();
					int price = Integer.parseInt(st.nextToken());
					int quantity = Integer.parseInt(st.nextToken());
					Product product = new Product(key, name, price, quantity);
					productList.add(product);
					
				}
			}
			buff.close();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	//checks if name and quantity of the product are valid
	public int checkProduct(String purchase){
		int status = 0;
		StringTokenizer st = new StringTokenizer(purchase, "|");
		String purchaseProduct = st.nextToken();
		int purchaseQuantity = Integer.parseInt(st.nextToken());	
		for(int p = 0; p < productList.size(); p++){
			if(productList.get(p).name.equals(purchaseProduct))
			{
				if(productList.get(p).quantity >= purchaseQuantity){
					//product name and quantity are valid
					//purchase is performed
					 status = 1;
					 removeFromStock(purchaseProduct, purchaseQuantity);
					 break;
				}
				else if(productList.get(p).quantity < purchaseQuantity){
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
	public Product returnProduct(String order){
		Product product = null;
		StringTokenizer st = new StringTokenizer(order,"|");
		String cartProduct = st.nextToken();
		int cartQuantity = Integer.parseInt(st.nextToken());
		for(Product p : productList){
			if(p.name.equals(cartProduct)){
				product = new Product(p.key, cartProduct, p.price, cartQuantity);
				return product;
			}
		}
		return null;
	}
	
}
