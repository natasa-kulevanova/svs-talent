import java.util.InputMismatchException;
import java.util.Scanner;


public class ProductApp {

	private static WareHouse wareHouse;
	private static ShoppingCart shoppingCart; 
	static String str = "products.txt";

	public static void main(String[] args){
		
		wareHouse = new WareHouse(str);
		shoppingCart = new ShoppingCart();
		boolean run = true;
	//	String purchase;
		int purchaseStatus=0;
		int choice=0;
		
		while(run){
			System.out.println("Enter 1, 2 or 3 (1-display full product list; 2-shop; "
					+ "3-proceed chekout). Enter 0 when finished.");
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
					System.out.println("Full list of products:");
					for(int i = 0; i < wareHouse.productList.size(); i++){
						System.out.println("Product_"+ (i+1) + " Name:"+ wareHouse.productList.get(i).name + " Price:"
								+ wareHouse.productList.get(i).price);
					}
					break;
				}
				case 2: {
					System.out.println("Enter the name and quantity of the product that you want to purchase (example: Bag|2)");
					Scanner input2 = new Scanner(System.in);
					String purchase = input2.nextLine();
					if(purchase.contains("|")){
					purchaseStatus = wareHouse.checkProduct(purchase);		
					}
					else{
						System.out.println("Please enter a products as asked!");
					}
					if(purchaseStatus == 1){
						Product p = wareHouse.returnProduct(purchase);
							shoppingCart.addToCart(p);
							System.out.println("New product has been added to your shopping basket");
							purchase="";
					}
					else if(purchaseStatus == 2){
						System.out.println("Product name is not valid!");
					}
					else if(purchaseStatus == 3){
						System.out.println("We dont have that much in stock. Try again with smaller quantity (or other product).");
					}
					break;
				}
				case 3: {
					System.out.println("Your shopping basket: ");
					shoppingCart.displayCart();
					break;
				}
				case 0:{
					System.out.println("Thank you for your visit.");
					run=false;
					break;	
				}
				default: run=false; break;
				
			}
		}
	}
}
