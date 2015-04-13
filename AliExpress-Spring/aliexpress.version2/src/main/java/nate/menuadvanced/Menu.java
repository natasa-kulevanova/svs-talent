package nate.menuadvanced;

import nate.menuadvanced.UIinterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class Menu {

	private UIinterface ui;
	
	
	@Autowired
	public Menu(UIinterface ui) {
		this.ui = ui;
	}

	public abstract Operation[] getOperations();

	public void run() {
		while (true) {
			Operation[] operations = getOperations();

			for (int i = 0; i < operations.length; i++) {
				ui.print((i + 1) + ". " + operations[i].getTitle());
			}
			ui.print("0. Return");

			try {
				int choice = Integer.parseInt(ui.requestInput("---> Enter command: <---"));
				if (choice == 0) {
					break;
				}
				operations[choice - 1].execute();
			} catch (NumberFormatException e) {
				ui.print("Invalid input!");
			} catch (ArrayIndexOutOfBoundsException e) {
				ui.print("Invalid input!");
			} 
		}
	}
}
