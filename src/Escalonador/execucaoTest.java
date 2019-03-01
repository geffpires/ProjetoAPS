package Escalonador;

public class execucaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Escalonador e = new Escalonador(3);
		e.addProcess("p1", 0, 5);
		e.addProcess("p2", 3, 3);
		e.addProcess("p3", 4, 3);
		e.run2();
		//System.out.println(e.size());
		System.out.println(e.graficoProcess());
	}
}
