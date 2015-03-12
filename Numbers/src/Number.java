
public class Number {

	public static void main(String[] args)
	{
		int stepen = args.length-1;
		int result = 0;
		for(int i=0; i<args.length;i++){
			result+=parseNumber(args[i])*(Math.pow(10, stepen));
			stepen--;
		}
		System.out.println(result);
	}
	
	
	public static int parseNumber(String num)
	{
		int value = 0;
		switch(num){
		case "zero": value=0; break;
		case "one": value=1; break;
		case "two": value = 2; break;
		case "three": value=3; break;
		case "four": value=4; break;
		case "five": value = 5; break;
		case "six": value=6; break;
		case "seven": value=7; break;
		case "eight": value = 8; break;
		case "nine": value = 9; break;
		}
		return value;
	}
}
