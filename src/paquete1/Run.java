package paquete1;

import java.util.ArrayList;
import java.util.List;

public class Run {
	public static void main(String[] args) {
        LogMensajes logMensajes = new LogMensajes();
        List<Thread> hilos = new ArrayList<>();
        
        for(int i = 1; i <= 10; i++) {
        	Usuario usuario = new Usuario("Usuario" + i, logMensajes);
        	Thread thread = new Thread(() -> usuario.enviarMensajes(logMensajes));
        	hilos.add(thread);
        	thread.start();
        }
        
        for (Thread thread : hilos) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

        logMensajes.imprimirColaMensajes();
        
    }

}
