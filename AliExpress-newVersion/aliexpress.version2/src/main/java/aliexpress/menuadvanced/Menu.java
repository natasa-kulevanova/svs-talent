package aliexpress.menuadvanced;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aliexpress.menuadvanced.UIinterface;

@Component
public abstract class Menu {

	private UIinterface ui;
	
	
	@Autowired
	public Menu(UIinterface ui) {
		this.ui = ui;
	}

	public abstract Action[] getActions();

	public void run() {
		while (true) {
			Action[] actions = getActions();

			for (int i = 0; i < actions.length; i++) {
				ui.print((i + 1) + ". " + actions[i].getTitle());
			}
			ui.print("0. Return");

			try {
				int choice = Integer.parseInt(ui.requestInput("Enter command"));
				if (choice == 0) {
					break;
				}
				actions[choice - 1].execute();
			} catch (NumberFormatException e) {
				ui.print("Invalid input!");
			} catch (ArrayIndexOutOfBoundsException e) {
				ui.print("Invalid input!");
			} 
		}
	}
}
