package Escalonador;

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
		runing = new ArrayList<Process>();
		waiting = new ArrayList<Process>();
		finished = new ArrayList<Process>();
		novos = new ArrayList<Process>();
		processos =  new ArrayList<Process>();
		
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
	
	public List<Process> getProcessos(){
		List<Process> processos = new ArrayList<Process>();
		for (Process p: this.novos){
			processos.add(p);
		}
		for (Process p:this.runing) {
			processos.add(p);
		}
		return processos;
	}
	//metodo pode ser descartado ?()
	public void addProcessInList() {
		
		for (Process p: this.getProcessos()) {
			if (p.getStatus() == 'I') {
				this.addInexistente(p);
				
			}else if(p.getStatus() == 'R') {
				this.addRuning(p);
				
			}else if(p.getStatus() == 'W') {
				this.addWaiting(p);
				
			}else {
				this.addFinished(p);
				
			}
		}
	}
	
	public void run() {

		while (time < 0) {
			
			for (Process p: processos) {
				if (p.getStart() == time) {
					this.addNovos(p);
				}
			}
			int count = 0;
			while (true){
				if (count == quant) {
					this.getProcessos().get(0).setStatus('W');
					this.addWaiting(this.getProcessos().get(0));
					break;
				}
				this.getProcessos().get(0).setRunTime();
				count++;
			}
			
			time++;
		}
	}
	

}
