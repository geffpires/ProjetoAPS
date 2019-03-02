package Escalonador;

public class execucaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Escalonador e;
		try {
			e = new Escalonador(2);
			e.addProcess("p1", 0, 3);
			e.addProcess("p2", 3, 6);
			e.addProcess("p3", 6, 9);
			e.run2();
			//System.out.println(e.size());
			System.out.println(e.graficoProcess());
		} catch (EscalonadorException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		
	}
}
