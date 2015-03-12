
public class BoxTest {

	public static void main(String[] argd){
	
	Box first = new Box(2,2,2);
	Box second = new Box(3,3,3);
	
	int volume1 = first.boxVolume();
	int volume2 = second.boxVolume();
	
	if(volume1 > volume2)
	System.out.println("First box has greater volume. The volume is: " +volume1);
	
	else
		System.out.println("Second box has greater volume. The volume is: " +volume2);
	
	
	}
}
