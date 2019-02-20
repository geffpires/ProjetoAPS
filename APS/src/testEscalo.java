import org.junit.Assert;
import org.junit.jupiter.api.Test;





class testEscalo {

	@Test
	public void testEscalonador() {
		Escala escalonador = new Escala();
		Assert.assertTrue("Escalonador está funcionando", escalonador.positivo());
		
		
		Escala resultado = new Escala();
		Assert.assertTrue("Processos estão escalonados", resultado.escalonamento());
		
	}
	
	
} 
