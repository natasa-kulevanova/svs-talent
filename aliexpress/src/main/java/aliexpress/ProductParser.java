package aliexpress;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ProductParser {

	public static ArrayList<Product> readProducts(String str){
		ArrayList<Product> productList = new ArrayList<Product>();
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
					int key = Integer.parseInt(st.nextToken());
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
		return productList;
	}
	
}
