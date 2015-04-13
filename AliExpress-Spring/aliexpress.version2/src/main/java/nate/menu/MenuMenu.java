package nate.menu;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MenuMenu {

	private static boolean run = true;
	private static int choice;
	
	public static void run(Scanner in){
		while (run) {
			System.out.println("Enter a command:");
			System.out.println("1. Account management");
			System.out.println("2. Product management");
			System.out.println("0. To terminate");

			try {
				choice = in.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid enter!!! Try again.");
			}

			switch (choice) {

				case 1: {
					AccountMenu.run(in);
					break;
				}
	
				case 2: {
					ProductMenu.run(in);
					break;
				}
	
				case 0: {
					System.out.println("Goodbye!!!");
					run = false;
					break;
				}
	
				default: {
					System.out.println("Invalid enter!!! Enter 1, 2, 3 or 0.");
				}
			}
		}
	}
}
	