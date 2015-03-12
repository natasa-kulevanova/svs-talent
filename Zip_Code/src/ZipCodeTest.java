
public class ZipCodeTest {

	public static void main(String[] args)
	{
		String value1 = "12345";
		String value2 = "12345ppp";
		
		System.out.println("Create zipcode object zc1 using zipcode value: "+value1);
		ZipCode zc1 = new ZipCode(value1);
		System.out.println("Create zipcode object zc2 using zipcode value: "+value2);
		ZipCode zc2 = new ZipCode(value2);
	}
}
