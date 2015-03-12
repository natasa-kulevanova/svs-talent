
public class Box {

	public int height;
	public int weight;
	public int depth;
	
	public Box(int x, int y, int z){
		height = x;
		weight = y;
		depth = z;
	}
	
	public int boxVolume(){
		return height*weight*depth;
	}
}
