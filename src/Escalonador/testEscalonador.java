package Escalonador;

import static org.junit.Assert.*;

import org.junit.Test;

public class testEscalonador {
	Escalonador escalonador = new Escalonador(3);
	@Test
	public void addProcesso() {
		
		escalonador.addProcess("P01", 0, 3);
		escalonador.addProcess("P02", 3, 6);
		escalonador.addProcess("P03", 6, 9);
	}	
	
}
