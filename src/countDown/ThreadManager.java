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
    	    	
    	threads.add(new Thread(c1));
    	threads.add(new Thread(c2));
    	threads.add(new Thread(c3));
    	
    	for (Thread thread : threads) {
			thread.start();
			threadStates.put(System.currentTimeMillis(), thread.getName());
		}

    }

    public void monitoreaThreads() throws InterruptedException {
        boolean allThreadsTerminated = false;

        // Monitorea hasta que todos los hilos hayan terminado.
        // Para ello cada 90 milisegundos aproximadamente
        // almacena en el map para cada hilo la información:
        //    - clave -> timestamp 
        //    - valor -> cadena con nombre y estado 
        //    - ejemplo de la cadena: C1:RUNNABLE
        // y vefica si todos han terminado.
    }

    public void printThreadStates() {
        // Imprimir todos los estados registrados en el TreeMap
        System.out.println("\nResumen de estados de los hilos:");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadManager manager = new ThreadManager();
        manager.startThreads();
        manager.monitoreaThreads();
        manager.printThreadStates();
        // Responde brevemente a las siguientes preguntas:
        //  1.- Motivo de la frecuencia del estado RUNNABLE
        //  2.- Motivo de la frecuencia del estado TIMED_WAITING
        //  3.- Motivo de la frecuencia del estado TERMINATED
        System.out.println("Respuestas a las preguntas");
        System.out.println("1: ");
        System.out.println("2: ");
        System.out.println("3: ");       
    }

}
