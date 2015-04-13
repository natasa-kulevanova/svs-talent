package aliexpress.menuadvanced;

import java.util.Scanner;

import org.springframework.stereotype.Component;
import aliexpress.menuadvanced.UIinterface;

@Component
public class UI implements UIinterface{

	private Scanner scanner = new Scanner(System.in);
		
	public String requestInput(String string) {
		System.out.println("Enter " + string + ":");
		return scanner.next();
	}

	public void print(String message) {
		System.out.println(message);
	}

	

}
