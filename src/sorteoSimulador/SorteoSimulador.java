package sorteoSimulador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SorteoSimulador {
	private String nombre;
	private int bolaInicial;
	private int bolaFinal;
	private int cantidadBolas;
	List<Integer> numeroSeleccionados = new ArrayList<>();

	public SorteoSimulador(String nombre, int bolaInicial, int bolaFinal, int cantidadBolas) {
		this.nombre = nombre;
		this.bolaInicial = bolaInicial;
		this.bolaFinal = bolaFinal;
		this.cantidadBolas = cantidadBolas;
	}

	@Override
	public String toString() {
		return "Sorteo " + nombre + " desde la bola " + bolaInicial + " a la " + bolaFinal + " donde se extraen "
				+ cantidadBolas + " bolas";
	}

	public void generaUnaCombinaciónGanadora(long milis) {
		try {

			for (int i = bolaInicial; i <= bolaFinal; i++) {
				numeroSeleccionados.add(i);
			}
			System.out.println("");
			System.out.println(toString());
			System.out.println("");
			Collections.shuffle(numeroSeleccionados);
			numeroSeleccionados = numeroSeleccionados.stream().limit(cantidadBolas).sorted().collect(Collectors.toList());
			for (Integer integer : numeroSeleccionados) {
				Thread.sleep(milis);
				System.out.println("-bonoloto: " + integer);
			}
			System.out.println("");
			System.out.println("bonoloto les desea mucha suerte.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
