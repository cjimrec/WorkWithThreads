package sorteoSimulador;

public class Run {
	public static void main(String[] args) {
		System.out.println("BONOLOTO ESPAÑOLA");
		SorteoSimulador s1 = new SorteoSimulador("loto", 1, 49, 6);
		s1.generaUnaCombinaciónGanadora(500);
		System.out.println("");
		System.out.println("NUMEROS DEL 10 AL 70");
		System.out.println("");
		SorteoSimulador s2 = new SorteoSimulador("loto", 10, 70, 5);
		s2.generaUnaCombinaciónGanadora(500);		
		TSorteoSimulator t1 = new TSorteoSimulator("T1", 1, 90, 5);
		t1.start();
		RSorteoSimulator r1 = new RSorteoSimulator("r1", 1, 49, 6);		
		new Thread(r1).start();
		LSorteoSimulator l1 = new LSorteoSimulator(s1);
		l1.start();
	}
}
