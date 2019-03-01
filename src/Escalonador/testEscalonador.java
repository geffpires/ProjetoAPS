package Escalonador;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;





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
	@SuppressWarnings("deprecation")
	@Test 
	public void testRun() {
		
		String resultado = ""
				+"p1: RRRWWWWWWRRF\n"
				+"p2: IIIRRRFFFFFF\n"
				+"p3: IIIIWWRRRFFF";
		
		
		Assert.assertEquals(escalonador.graficoProcess(), resultado);
		
	
}
	}
	