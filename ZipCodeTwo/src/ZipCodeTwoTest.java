
public class ZipCodeTwoTest {

	public static void main(String[] args){
		String s = "12345";
		try{
			ZipCodeTwo zc = new ZipCodeTwo(s);
		} catch (InvalidValueException e){
			e.printStackTrace();
		}
	}
}
