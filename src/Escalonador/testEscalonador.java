package Escalonador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class testEscalonador {


	
	Escalonador escalonador;

	
	@Before
	public void iniciar() {
		try {
			escalonador=new Escalonador(3);
		} catch (EscalonadorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testAddProcesso() {
		

		escalonador.addProcess("P01", 0, 3);
		escalonador.addProcess("P02", 3, 3);
		escalonador.addProcess("P03", 4, 6);
		

		escalonador.addProcess("p1", 0, 3);
		escalonador.addProcess("p2", 3, 6);
		escalonador.addProcess("p3", 6, 9);
		escalonador.run2();
		assertEquals("p1: RRRFFFFFFFFFFFFFFFF\n" + "p2: IIIRRRWWWRRRFFFFFFF\n" + "p3: IIIIIIRRRWWWRRRRRRF\n",escalonador.graficoProcess());
	}
	@Test
	public void p1NaoNovo() {
		escalonador.addProcess("p1", 0, 3);
		escalonador.addProcess("p2", 3, 6);
		escalonador.addProcess("p3", 6, 9);
		escalonador.runTesteParte1();
		assertTrue(escalonador.getNovos().size()==1);
		escalonador.runTesteParte2();
		escalonador.runTesteParte1();
		assertTrue(escalonador.getNovos().size()==0);
		
		
	}
	@Test
	public void processNull() {
		escalonador.addProcess("p1", 0, 3);
		escalonador.addProcess("p2", 3, 6);
		escalonador.addProcess("p3", 6, 9);
		escalonador.runTesteParte1();
		assertTrue(escalonador.getRunning()==null);
		escalonador.runTesteParte2();
		assertTrue(escalonador.getRunning()!=null);
		
	}
	
	@Test
	public void preenpcao() {
		escalonador.addProcess("p1", 0, 3);
		escalonador.addProcess("p2", 3, 6);
		escalonador.addProcess("p3", 6, 9);
		escalonador.runTesteParte1();
		escalonador.runTesteParte2();
		
		escalonador.runTesteParte1();
		escalonador.runTesteParte2();
		
		escalonador.runTesteParte1();
		escalonador.runTesteParte2();
		
		escalonador.runTesteParte1();
		escalonador.runTesteParte2();
		
		escalonador.runTesteParte1();
		escalonador.runTesteParte2();
		Process p2 = new Process();
		p2=escalonador.getRunning();
		assertTrue(p2.getStatus().equals("R"));
		assertTrue(p2.getName().equals("p2"));
		
		escalonador.runTesteParte1();
		escalonador.runTesteParte2();
		
		escalonador.runTesteParte1();
		escalonador.runTesteParte2();
		
		for(Process p: escalonador.getWaiting()) {
			if(p.getName().equals("p2")) {
				p2=p;
			}
		}
		assertTrue(p2.getStatus().equals("W"));
		assertTrue(p2.getName().equals("p2"));
	}
	
	@Test
	public void mudarOQuant2() {
		escalonador.setQuant(2);
		escalonador.addProcess("p1", 0, 3);
		escalonador.addProcess("p2", 3, 6);
		escalonador.addProcess("p3", 6, 9);
		escalonador.run2();
		assertEquals(
		"p1: RRRFFFFFFFFFFFFFFFF\n" + 
		"p2: IIIRRRWWRRWWRFFFFFF\n" + 
		"p3: IIIIIIRRWWRRWRRRRRF\n",escalonador.graficoProcess());
	}
	
	@Test
	public void processInexistInicio() {
		escalonador.addProcess("p1", 3, 3);
		escalonador.addProcess("p2", 3, 3);
		escalonador.addProcess("p3", 3, 3);
		
		escalonador.runTesteParte1();
		escalonador.runTesteParte2();
		
		assertTrue(escalonador.getRunning()==null);
		assertTrue(escalonador.getProcess().get(0).getStatus() == "I");
		assertTrue(escalonador.getProcess().get(1).getStatus() == "I");
		assertTrue(escalonador.getProcess().get(2).getStatus() == "I");
		
		escalonador.runTesteParte1();
		escalonador.runTesteParte2();
		
		assertTrue(escalonador.getRunning()==null);
		assertTrue(escalonador.getProcess().get(0).getStatus() == "I");
		assertTrue(escalonador.getProcess().get(1).getStatus() == "I");
		assertTrue(escalonador.getProcess().get(2).getStatus() == "I");
		
		escalonador.runTesteParte1();
		escalonador.runTesteParte2();
		
		assertTrue(escalonador.getRunning()==null);
		assertTrue(escalonador.getProcess().get(0).getStatus() == "I");
		assertTrue(escalonador.getProcess().get(1).getStatus() == "I");
		assertTrue(escalonador.getProcess().get(2).getStatus() == "I");
		
		escalonador.runTesteParte1();
		escalonador.runTesteParte2();
		
		assertTrue(escalonador.getRunning().getName().equals("p1"));
		
	}
	
	// P01 0 3
	// P02 0 3
	// P03 5 7
	@Test
	public void run1() {
		
		escalonador.addProcess("P01", 0, 3);
		escalonador.addProcess("P02", 0, 3);
		escalonador.addProcess("P03", 5, 7);
		
		
		String resultado = "p1: RRRF\n"
				+ "p2: WWWRRRF\n"
				+ "p3: IIIIIWRRF";
		
		if (escalonador.graficoProcess() == resultado) {
			escalonador.fimEscalonador();
		}
	}
	
	
	// P01 0 3
	// P02 3 5
	// PO3 5 7
	@Test
	public void run2() {
		
		escalonador.addProcess("P01", 0, 3);
		escalonador.addProcess("P02", 3, 5);
		escalonador.addProcess("P03", 5, 7);
		
		
		String resultado = "p1: RRRF\n"
				+ "p2: IIIRRF\n"
				+ "p3: IIIIIRRF";
		
		if (escalonador.graficoProcess() == resultado) {
			escalonador.fimEscalonador();
		}
	}
	
	// P01 0 10	
	@Test
	public void run3() {
		
		escalonador.addProcess("P01", 0, 10);
				
		
		String resultado = "p1: RRRRRRRRRRF\n";
				
				
		
		if (escalonador.graficoProcess() == resultado) {
			escalonador.fimEscalonador();
		}
	}
	// P01 0 5
	// P02 5 10
	// P03 5 8
	
	
	@Test
	public void run4() {
		
		escalonador.addProcess("P01", 0, 5);
		escalonador.addProcess("P02", 5, 10);
		escalonador.addProcess("P03", 5, 8);
		
		
		String resultado = "p1: RRRRRF\n"
				+ "p2: IIIIIRRRWWWRRF\n"
				+ "p3: IIIIIWWWRRRF";
		
		if (escalonador.graficoProcess() == resultado) {
			escalonador.fimEscalonador();
		}
	}
	
	
}


	