
public class ZipCodeTwo {

	private String code;
	
	public ZipCodeTwo(String s) throws InvalidValueException{
		if(s.length()==5 || s.length()==9){
			if(s.matches("[0-9]+")){
				this.code = s;
				System.out.println("Success!");
			}
		}
		else{
			throw new InvalidValueException();
		}
	}
}
