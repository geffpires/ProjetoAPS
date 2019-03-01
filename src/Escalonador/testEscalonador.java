package Escalonador;

import org.junit.Assert;
import org.junit.Test;







public class testEscalonador {
	Escalonador escalonador = new Escalonador(3);
	
	@Test
	public void testAddProcesso() {
		
		escalonador.addProcess("P01", 0, 3);
		escalonador.addProcess("P02", 3, 3);
		escalonador.addProcess("P03", 4, 6);
	}	
	
	
	// P01 0 3
	// P02 3 3
	// P03 4 6
	
	@Test 
	public void testRun() {
		escalonador.addProcess("P01", 0, 3);
		escalonador.addProcess("P02", 3, 3);
		escalonador.addProcess("P03", 4, 6);	
		
		String resultado = "p1: RRRWWWWWWRRF\n"
				+"p2: IIIRRRFFFFFF\n"
				+"p3: IIIIWWRRRFFF";
		
		
		if(escalonador.graficoProcess() == resultado) {
			
		}
		
	
}

		// P01 0 3
		// P02 0 3
		// P03 3 6
		
		@Test 
		public void testRun2() {
			escalonador.addProcess("P01", 0, 3);
			escalonador.addProcess("P02", 0, 3);
			escalonador.addProcess("P03", 3, 6);	
			
			String resultado = ""
					+"p1: RRRF\n"
					+"p2: WWWRRRF\n"
					+"p3: IIIWWWRRRF";
			
			if(escalonador.graficoProcess() == resultado) {
				
			}
			
		
		}
		// PO1 RRF
		// P02 WWWRRRF
		@Test 
		public void testRun3() {
			escalonador.addProcess("P01", 0, 3);
			escalonador.addProcess("P02", 0, 3);
			
			
			String resultado = ""
					+"p1: RRRF\n"
					+"p2: WWWRRRF\n";
			
			if(escalonador.graficoProcess() == resultado) {
				
			}
			
			








		}
}


	