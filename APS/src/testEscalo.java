import org.junit.Assert;
import org.junit.jupiter.api.Test;





class testEscalo {
	Escala escalonador = new Escala();
	@Test
	public void funcionaEscalonador() {
		;
		Assert.assertTrue("Escalonador est� funcionando", escalonador.positivo());
	}
	@Test
	public void testEscalonamento() {	
		
		Assert.assertTrue("Processos est�o escalonados", escalonador.escalonamento());
		
	}
	@Test
	public void testAdicionaProcessos() {
		
		escalonador.addProcesso("P01", 0, 3);
	
	}
	
	@Test
	public void testQuantum() {
		
		escalonador.setQuantum(3);
	}
	
	
} 
