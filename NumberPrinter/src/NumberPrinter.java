


public class NumberPrinter {

	public static void main(String[] args) throws Exception{
		
		int number = Integer.valueOf(args[0]);
		int time = Integer.valueOf(args[1]);
		
		final NumberTask task = new NumberTask(number);
		final Thread taskThread = new Thread(task);
		taskThread.start();
		
		Thread.sleep(time);
		System.out.println("Interupting the task...");
		taskThread.interrupt();
		
		
	}
	
	
	public static class NumberTask implements Runnable{
		
		public int number;
		
		public NumberTask(int n) {
			number=n;
		}
		@Override
		public void run(){	
			for(int i =1; i<=number; i++){
				if(Thread.interrupted()){
					System.out.print("I've been interrupted");
					return;
				}
			
				System.out.println("Number: " +i);
			}
			
		}
	}
}
