import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CountDownLatchApplication {

    private static final int NUMBER_OF_OPERATIONS = 5;

    public static void main(String[] args) throws Exception {
    	
    	ArrayList<Future<Integer>> arr = new ArrayList<Future<Integer>>();
    	
    	
        final CountDownLatch latch = new CountDownLatch(NUMBER_OF_OPERATIONS);
        final ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 1; i <= NUMBER_OF_OPERATIONS; i++) {
        	 
             arr.add(executorService.submit(new ComplexCalculation(i, latch)));
        }

        System.out.println("Waithing for all complex operations to finish...");
        latch.await();
        
        int max = arr.get(0).get();
        for(Future<Integer> f : arr){
        	if(max < f.get()){
        		max = f.get();
        	}
        }
        System.out.println("All complex operations finished.");
        System.out.println("Maximum is: "+max);
        executorService.shutdown();
    }
}
