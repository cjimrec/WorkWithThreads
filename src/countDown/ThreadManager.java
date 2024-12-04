package countDown;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ThreadManager {

    private List<Thread> threads = new ArrayList<>();
    private TreeMap<Long, String> threadStates = new TreeMap<>();

    public void startThreads() {
    	CountDown c1 = new CountDown("C1", 10);
    	CountDown c2 = new CountDown("C2", 8);
    	CountDown c3 = new CountDown("C3", 7);
    	
    	Thread thread1 = new Thread(c1);
        thread1.setName("C1");
        Thread thread2 = new Thread(c2);
        thread2.setName("C2");
        Thread thread3 = new Thread(c3);
        thread3.setName("C3");
        
    	threads.add(thread1);
    	threads.add(thread2);
    	threads.add(thread3);
    	
    	for (Thread thread : threads) {
			thread.start();
			threadStates.put(System.currentTimeMillis(), thread.getName());
		}

    }

    public void monitoreaThreads() throws InterruptedException {
        boolean allThreadsTerminated = false;
        while (!allThreadsTerminated) {
            allThreadsTerminated = true;
            for (Thread thread : threads) {
                threadStates.put(System.currentTimeMillis(), thread.getName()+ thread.getState());
                if (thread.getState() != Thread.State.TERMINATED) {
                    allThreadsTerminated = false;
                }
            }
            Thread.sleep(90);
        }
        for (Thread thread : threads) {
            threadStates.put(System.currentTimeMillis(), thread.getName() + ":" + thread.getState());
        }
    }

    public void printThreadStates() {
        System.out.println("\nResumen de estados de los hilos:");
        for (Map.Entry<Long, String> datos : threadStates.entrySet()) {
        	System.out.println("Time " + datos.getKey() + " estado : "+ datos.getValue());
		}    
     }

    public static void main(String[] args) throws InterruptedException {
        ThreadManager manager = new ThreadManager();
        manager.startThreads();
        manager.monitoreaThreads();
        manager.printThreadStates();
        System.out.println("Respuestas a las preguntas");
        System.out.println("1: Esto significa que el hilo está arrancado, lo que no se sabe si esta en ejecucion");
        System.out.println("2: El hilo esta esperando que otro hilo termine");
        System.out.println("3: Significa que el hilo ha terminado de ejecutarse");       
    }
    

}
