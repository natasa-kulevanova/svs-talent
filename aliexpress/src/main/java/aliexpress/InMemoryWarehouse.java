package aliexpress;

import java.util.ArrayList;

public class InMemoryWarehouse implements WarehouseInterface {

public ArrayList<Product> productList = new ArrayList<Product>();
	
	public InMemoryWarehouse(){
		productList = new ArrayList<Product>();
	}
	
	public int checkProduct(String name, int quantity) {
		int status = 0;
		for(int p = 0; p < productList.size(); p++){
			if(productList.get(p).getName().equals(name))
			{
				if(productList.get(p).getQuantity() >= quantity){
					//product name and quantity are valid
					//purchase is performed
					 status = 1;
					 removeFromStock(name, quantity);
					 break;
				}
				else if(productList.get(p).getQuantity() < quantity){
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

	public void removeFromStock(String nameR, int quantityR) {
		for(int i = 0; i < productList.size(); i++){
			if(productList.get(i).getName().equals(nameR)){
				int q = productList.get(i).getQuantity() - quantityR;
				productList.get(i).setQuantity(q);
			}
		}
		
	}

	public Product getProduct(String nameS, int quantityS) {
		Product product = null;
		for(Product p : productList){
			if(p.getName().equals(nameS)){
				product = new Product(p.getKey(), nameS, p.getPrice(), quantityS);
				return product;
			}
		}
		return null;
	}

	public ArrayList<Product> listProducts() {
		return this.productList;
	}

	public void addProduct(Product product) {
		productList.add(product);
		
	}

}
