package sorteoSimulador;

public class LSorteoSimulator extends Thread{
	private SorteoSimulador sorteo;
	
	public LSorteoSimulator(SorteoSimulador sorteo) {
		this.sorteo = sorteo;
	}

	@Override
	public void run() {
		System.out.println("LSORTEOSIMULATOR");
		sorteo.generaUnaCombinaciónGanadora(500);
	}
}
