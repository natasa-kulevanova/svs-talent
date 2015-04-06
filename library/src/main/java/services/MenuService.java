package services;



import menus.MenuInterface;

public class MenuService {

	MenuInterface menu;
	
	public MenuService(MenuInterface m){
		menu = m;
	}
	
	public void list(){
		menu.list();
	}
	
	public void register(){
		menu.register();
	}
	
	public void delete(){
		menu.delete();
	}
	
	public void update(){
		menu.update();
	}
}
