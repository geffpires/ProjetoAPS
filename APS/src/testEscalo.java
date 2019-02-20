import org.junit.Assert;
import org.junit.jupiter.api.Test;





class testEscalo {

	@Test
	public void funcionaEscalonador() {
		Escala escalonador = new Escala();
		Assert.assertTrue("Escalonador est� funcionando", escalonador.positivo());
	}
	@Test
	public void testEscalonamento() {	
		Escala escalonador = new Escala();
		Assert.assertTrue("Processos est�o escalonados", escalonador.escalonamento());
		
	}
	@Test
	public void testAdicionaProcessos() {
		Escala escalonador = new Escala();
		escalonador.addProcesso("P01", 0, 3);
	
	}
	
	@Test
	public void testQuantum() {
		Escala escalonador = new Escala();
		escalonador.setQuantum(3);
	}
} 
