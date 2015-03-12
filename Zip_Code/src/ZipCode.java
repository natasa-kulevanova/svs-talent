
public class ZipCode {

	private String code;
	private String check = "^[0-9]";
	
	public ZipCode(String s){
		if(s.length()==5 || s.length()==9)
		{
			if(s.matches(check))
				code = s;
				System.out.println("Success!");
			
		}
		else System.out.println("Fail! Must be five or nine digit value!");
	}
}
