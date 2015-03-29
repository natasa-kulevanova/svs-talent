package aliexpress;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AliexpressApp {

	private static WarehouseInterface wareHouse;
	private static ShoppingCart shoppingCart; 
	static String str = "products.txt";

	public static void main(String[] args){
		
		shoppingCart = new ShoppingCart();
		boolean run = true;
		int choice=0;
		System.out.println("Enter 1 to load into memort or 2 to load into database");
		Scanner in = new Scanner(System.in);
		if(in.nextInt()==1){
			wareHouse = new InMemoryWarehouse();
			for(Product p : ProductParser.readProducts(str))
				wareHouse.addProduct(p);
		}
		else {
			wareHouse = new JdbcWarehouse();
			if (wareHouse.listProducts() !=null){
				System.out.println("Database is loaded!");
			}
			else 
				for(Product p : ProductParser.readProducts(str))
					wareHouse.addProduct(p);
		}
		
		while(run){
			System.out.println("Enter 1, 2 or 3 (1-display full product list; 2-shop; "
					+ "3-proceed chekout). Enter 0 to terminate.");
			Scanner input = new Scanner(System.in);
			try{
			 choice = input.nextInt();
			}
			catch(InputMismatchException e){
				System.out.println("Invalid enter!!! Try again.");
				continue;
			}
			switch(choice){
				case 1: {
					listProducts();
					break;
				}
				case 2: {
					shop();
					break;
				}
				case 3: {
					System.out.println("Your shopping basket: ");
					displayCart(shoppingCart);
					break;
				}
				case 0:{
					System.out.println("Thank you for your visit.");
					run=false;
					break;	
				}
				default: System.out.println("Please enter a valid command."); break;
			}
		}
	}
	
	public static void listProducts(){
	
		for (Product p : wareHouse.listProducts())
			System.out.println("Product name: "+p.getName()+" | Price: "+p.getPrice());

	}
	
	public static void shop(){
		int purchaseStatus=0;
		System.out.println("Enter the name of the product that you want to purchase (example: Bag)");
		Scanner input2 = new Scanner(System.in);
		String productName = input2.nextLine();
		System.out.println("Enter the quantity of the product that you want to purchase (example: 2)");
		
		try{
			int productQuantity = input2.nextInt();
			purchaseStatus = wareHouse.checkProduct(productName, productQuantity);		
			if(purchaseStatus == 1){
				Product p = wareHouse.getProduct(productName, productQuantity);
					shoppingCart.addToCart(p);
					System.out.println("New product has been added to your shopping basket ("
					+productName+"|"+productQuantity+")");			
			}
			else if(purchaseStatus == 2){
				System.out.println("Product name is not valid!");
			}
			else if(purchaseStatus == 3){
				System.out.println("We dont have that much in stock. Try again with smaller quantity (or other product).");
			}
		}catch(InputMismatchException e){
			System.out.println("Enter integer value for the quatity!!!");
		}
		
	}
	
	public static void displayCart(ShoppingCart cart) {
		if(cart.shoppingList.isEmpty()){
			System.out.println("Empty!");
		}
		else {
			for(int i = 0; i < cart.shoppingList.size(); i++){
				System.out.println((cart.shoppingList.get(i).getName())+" quantity: "+(cart.shoppingList.get(i).getQuantity())+
						" price: "+cart.shoppingList.get(i).getPrice());
			}
			cart.totalPrice = cart.totalCost();
		}
		System.out.println("Total cost: "+cart.totalPrice+"$");
	}
}
