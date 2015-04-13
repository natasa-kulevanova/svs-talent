package nate.menuadvanced;

import java.util.Scanner;

import nate.menuadvanced.UIinterface;

import org.springframework.stereotype.Component;

@Component
public class UI implements UIinterface{

	private Scanner scanner = new Scanner(System.in);
		
	public String requestInput(String string) {
		System.out.println("\n"+string);
		return scanner.next();
	}

	public void print(String string) {
		System.out.println(string);
	}

	

}
