
public class ClientConsole {

	//displays all products and calculates total price of the shopping cart
	public static void displayCart(ShoppingCart cart) {
		if(cart.shoppingList.isEmpty()){
			System.out.println("Empty!");
		}
		else {
			for(int i = 0; i < cart.shoppingList.size(); i++){
				System.out.println((cart.shoppingList.get(i).name)+" quantity: "+(cart.shoppingList.get(i).quantity)+
						" price: "+cart.shoppingList.get(i).price);
			}
			cart.totalPrice = cart.totalCost();
		}
		System.out.println("Total cost: "+cart.totalPrice+"$");
	}
}
