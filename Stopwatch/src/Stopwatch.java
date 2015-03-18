
public class Stopwatch implements Runnable {

	private boolean run = true;
	private boolean pause = false;
	 private int i=0;
	
	@Override
	public void run(){
		while(run){
			System.out.println(i++);
			try{
				Thread.sleep(1000);
			}catch (InterruptedException e){
			}
			while(pause){
				try{
					synchronized(this){
						System.out.println("PAUSED");
						wait();
					}
				}
				catch(InterruptedException e){
				}
			} 		
		}
		System.out.println("Stopwatch STOPPED");
	}
	
	public void pause(){
		pause = true;
	}
	
	public void resume(){
		pause = false;
	}
	
	public void stop(){
		run = false;
	}
}

