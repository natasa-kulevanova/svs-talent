import java.util.Scanner;


public class StopwatchApp {
	
	public static void main(String[] args){
		final Stopwatch task = new Stopwatch();
		final Thread taskThreas = new Thread(task);
		
		System.out.println("Enter start to start, pause, resume or  stop...");			
		Scanner inp = new Scanner(System.in);
		String com = inp.nextLine();
		if(com.equals("start")){
			taskThreas.start();
		}
		while(true){
			String com1 = inp.nextLine();
			if(com1.equals("pause")){
				task.pause();
			}
			else if(com1.equals("resume")){
				task.resume();
				synchronized (task) {
					task.notifyAll();
				}
			}
			else if(com1.equals("stop")){
				task.stop();
				break;
			}
		}
	}
	
	
}
