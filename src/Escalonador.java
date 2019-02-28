

import java.util.ArrayList;
import java.util.List;

public class Escalonador {
	
	private List<Process> processos;
	private List<Process> novos;
	private List<Process> inexistente;
	private List<Process> runing;
	private List<Process> waiting;
	private List<Process> finished;
	private int time = 0;
	private int quant;
	
	public Escalonador(int quant) {
		
		this.quant = quant;
		inexistente = new ArrayList<Process>();
		waiting = new ArrayList<Process>();
		finished = new ArrayList<Process>();
		novos = new ArrayList<Process>();
		processos =  new ArrayList<Process>();
		
	}
	public int getTime() {
		return this.time;
	}
	public int getQuant() {
		return this.quant;
	}
	public void addProcess(Process p) {
		this.processos.add(p);
	}
	public List<Process> getNovos() {
		return novos;
	}
	
	public void addNovos(Process novo) {
		this.novos.add(novo);
	}

	public List<Process> getInexistente() {
		return inexistente;
	}

	public void addInexistente(Process newInexistente) {
		this.inexistente.add(newInexistente);
	}

	public List<Process> getRuning() {
		return this.runing;
	}

	public void addRuning(Process newRuning) {
		this.runing.add(newRuning);
	}

	public List<Process> getWaiting() {
		return this.waiting;
	}

	public void addWaiting(Process newWaiting) {
		this.waiting.add(newWaiting);
	}

	public List<Process> getFinished() {
		return finished;
	}

	public void addFinished(Process newFinished) {
		this.finished.add(newFinished);
	}
	
	
	
	
	
	
	
	
	
	public List<Process> getProcessosEmExecucao(){
		List<Process> processos = new ArrayList<Process>();
		for (Process p: this.novos){
			processos.add(p);
		}
		for (Process p:this.waiting) {
			processos.add(p);
		}
		return processos;
	}
	
	public boolean fimEscalonador() {
		if (getProcessosEmExecucao().size() == 0 && this.processos.size() == 0) {
			return true;
		}
		return false;
	}

	public void mudarDeLista(List<Process> p, List<Process> i) {
		
	}
	
	public void run() {

		while (this.time < 0) {
			
			for (Process p: this.processos) {
				if (p.getStart() == this.time) {
					this.addNovos(p);
					this.processos.remove(p);
				}
			}
			while (true){
				if (this.getProcessosEmExecucao().get(0).getOnRun() == quant) {
		
					this.getProcessosEmExecucao().get(0).setStatus('W');
					this.addWaiting(this.getProcessosEmExecucao().get(0));
					break;
				}
				this.getProcessosEmExecucao().get(0).setRunTime();
			}
			
			this.time++;
			if (this.fimEscalonador()) {
				this.time = -1;
			}
		}
	}
	

}
