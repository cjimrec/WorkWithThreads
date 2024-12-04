package paquete1;

public class Usuario {
	   private String nombre;
	    private LogMensajes logMensajes;
	    private static Long nextIdMensaje = 0L;

	    public Usuario(String nombre, LogMensajes logMensajes) {
	        this.nombre = nombre;
	        this.logMensajes = logMensajes;
	    }

	    public void enviarMensajes(LogMensajes logMensajes) {
	        for (int i = 0; i < 100; i++) {
	            enviarMensaje();
	            pausar();
	        }
	    }

	    public void enviarMensaje() {
	        Long idMensaje = nextIdMensaje++;
	        logMensajes.registrarMensaje(idMensaje);
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
