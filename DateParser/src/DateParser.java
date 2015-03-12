import java.util.StringTokenizer;

public class DateParser{

	public static void main(String[] args)
	{
		String date = args[0];
		StringTokenizer str;
		str = new StringTokenizer(date, "/");
		System.out.println("Token1: "+str.nextToken());
		System.out.println("Token2: "+str.nextToken());
		System.out.println("Token3: "+str.nextToken());
	}
}