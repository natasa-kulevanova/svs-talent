package aliexpress.ali;

import java.util.ArrayList;

import aliexpress.entities.Product;

public class ShoppingCart {

	public ArrayList<Product> shoppingList = new ArrayList<Product>();
	public int totalPrice=0;
	
	public ShoppingCart(){
	}
	
	/*public void addToCart(Product p){
		if(shoppingList.contains(p))
		{
			for(Product pr : shoppingList){
				if(pr.getName().equals(p.getName())){
					pr.setQuantity(pr.getQuantity()+p.getQuantity());
				}
			}
		}
		else{
			shoppingList.add(p);
		}
		
	}
	*/

	public void addToCart(Product product) {
		if (this.containsProduct(product)) {
			Product p = this.getProduct(product.getName());
			p.setQuantity(p.getQuantity() + product.getQuantity());
			
		} else {
			Product p = new Product(product.getId(), product.getName(), product.getPrice(), product.getQuantity());
			p.setQuantity(product.getQuantity());
			this.shoppingList.add(p);
			
		}
	}
	
	public boolean containsProduct(Product product) {
		for (Product p : this.shoppingList)
			if (p.getName().equals(product.getName()))
				return true;
		return false;
	}
	
	public Product getProduct(String product){
		for (Product p : this.shoppingList)
			if(p.getName().equals(product))
				return p;
		return null;
	}
	
	//calculates the total cost from the shoppingCart
	public int totalCost(){
		totalPrice = 0;
		for(int i = 0; i < shoppingList.size(); i++){
			totalPrice+=(shoppingList.get(i).getPrice())*(shoppingList.get(i).getQuantity());
		}
		return totalPrice;
	}
}
