import java.util.ArrayList;


public class ShoppingCart {

	public ArrayList<Product> shoppingList = new ArrayList<Product>();
	public int totalPrice=0;
	
	public ShoppingCart(){
	}
	
	public void addToCart(Product p){
		shoppingList.add(p);
	}
	
	//displays all products from shoppingCart with the total cost
	public void displayCart() {
		if(shoppingList.isEmpty()){
			System.out.println("Empty!");
		}
		else {
			for(int i = 0; i < shoppingList.size(); i++){
				System.out.println((shoppingList.get(i).name)+" quantity: "+(shoppingList.get(i).quantity)+
						" price: "+shoppingList.get(i).price);
			}
			totalPrice = totalCost();
		}
		System.out.println("Total cost: "+totalPrice+"$");
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
