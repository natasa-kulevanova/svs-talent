import java.util.InputMismatchException;
import java.util.Scanner;


public class AliexpressApp {

	private static WareHouse wareHouse;
	private static ShoppingCart shoppingCart; 
	static String str = "products.txt";

	public static void main(String[] args){
		
		wareHouse = new WareHouse(str);
		shoppingCart = new ShoppingCart();
		boolean run = true;
	//	String purchase;
		int choice=0;
		
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
					ClientConsole.displayCart(shoppingCart);
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
		System.out.println("Full list of products:");
		for(int i = 0; i < wareHouse.productList.size(); i++){
			System.out.println("Product_"+ (i+1) + " Name:"+ wareHouse.productList.get(i).name + " Price:"
					+ wareHouse.productList.get(i).price);
		}
	}
	
	public static void shop(){
		int purchaseStatus=0;
		System.out.println("Enter the name of the product that you want to purchase (example: Bag)");
		Scanner input2 = new Scanner(System.in);
		String productName = input2.nextLine();
		System.out.println("Enter the quantity of the product that you want to purchase (example: 2)");
		int productQuantity = input2.nextInt();
		purchaseStatus = wareHouse.checkProduct(productName, productQuantity);		
		if(purchaseStatus == 1){
			Product p = wareHouse.getProduct(productName, productQuantity);
				shoppingCart.addToCart(p);
				System.out.println("New product has been added to your shopping basket");
				
		}
		else if(purchaseStatus == 2){
			System.out.println("Product name is not valid!");
		}
		else if(purchaseStatus == 3){
			System.out.println("We dont have that much in stock. Try again with smaller quantity (or other product).");
		}
	}
}
