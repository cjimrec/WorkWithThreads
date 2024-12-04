package paquete2;

import java.util.concurrent.atomic.AtomicLong;

public class Usuario {
	   private String nombre;
	    private LogMensajes logMensajes;
	    private static AtomicLong nextIdMensaje = new AtomicLong(0);

	    public Usuario(String nombre, LogMensajes logMensajes) {
	        this.nombre = nombre;
	        this.logMensajes = logMensajes;
	    }

	    public synchronized void  enviarMensajes(LogMensajes logMensajes) {
	        for (int i = 1; i <= 100; i++) {
	            enviarMensaje();
	            pausar();
	        }
	    }

	    public synchronized void enviarMensaje() {
	        Long idMensaje = nextIdMensaje.getAndIncrement();
	        logMensajes.registrarMensaje(idMensaje);
	        System.out.println(nombre + " envió el mensaje ID: " + idMensaje);
	    }

	    public void pausar() {
	        try {
	            //long tiempoEspera = (long) (Math.random() * (400 - 200)+1)+200;
	            Thread.sleep(10);
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }

}
