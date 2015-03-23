import java.util.ArrayList;


public class ShoppingCart {

	public ArrayList<Product> shoppingList = new ArrayList<Product>();
	public int totalPrice=0;
	
	public ShoppingCart(){
	}
	
	public void addToCart(Product p){
		shoppingList.add(p);
	}
	
	
	//calculates the total cost from the shoppingCart
	public int totalCost(){
		totalPrice = 0;
		for(int i = 0; i < shoppingList.size(); i++){
			totalPrice+=(shoppingList.get(i).price)*(shoppingList.get(i).quantity);
		}
		return totalPrice;
	}
}
