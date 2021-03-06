package Escalonador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Escalonador {
	
	private List<Process> processos;
	private List<Process> novos;
	private List<Process> inexistente;
	private List<Process> waiting;
	private List<Process> finished;
	private Process running;
	public Process getRunning() {
		return running;
	}
	private int time = 0;
	private int quant;
	
	public Escalonador(int quant) throws EscalonadorException{
		
		if (quant < 1) {
			throw new EscalonadorException ("O escalonador n�o pode ter o cont negativo");
		}
		
		this.quant = quant;
		this.inexistente = new ArrayList<Process>();
		this.processos = new ArrayList<Process>();
		this.waiting = new ArrayList<Process>();
		this.finished = new ArrayList<Process>();
		this.novos = new ArrayList<Process>();
		
	}
	public void orderListProcess() {
		Process aux = new Process();
		for (int x=0; x < finished.size(); x++) {
			for (int y= x+1; y< finished.size(); y++) {
				if (finished.get(x).getOrder() > finished.get(y).getOrder()) {
					aux = finished.get(x);
					finished.set(x, finished.get(y));
					finished.set(y, aux);
				}
			}
		}
		
	}
	
	public List<Process> getProcess(){
		return this.processos;
	}
	public int getTime() {
		return this.time;
	}
	public int getQuant() {
		return this.quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
	
	public void addProcess(String nome, int start, int endRun) {
		Process p = new Process(nome,start,endRun);
		p.setStatus("I");
		this.processos.add(p);
	}
	
	public List<Process> getNovos() {
		return novos;
	}
	
	public void addNovos(Process novo) {
		novo.setStatus("W");
		this.novos.add(novo);
	}

	public List<Process> getWaiting() {
		return this.waiting;
	}

	public void addWaiting(Process newWaiting) {
		newWaiting.setStatus("W");
		this.waiting.add(newWaiting);
	}

	public List<Process> getFinished() {
		return finished;
	}

	public void addFinished(Process newFinished) {
		newFinished.setStatus("F");
		this.finished.add(newFinished);
	}
	public Process escolherProcessParaRodar() {
		return this.getProcessosEmExecucao().get(0);
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
		if (getProcessosEmExecucao().size() == 0 && this.processos.size() == 0 && this.running==null) {
			return true;
		}
		return false;
	}
	public void allProcess(){
		for (Process p: this.processos) {
			p.addFeedback();
		}
		for (Process p:this.waiting) {
			p.addFeedback();
		}
		for (Process p:this.finished) {
			p.addFeedback();
		}
		for (Process p:this.novos) {
			p.addFeedback();
		}
	}
	
	public String graficoProcess() {
		String grafico = "";
		for (Process p: this.finished) {
			grafico += p.getFeedback()+"\n";
		}
		return grafico;
	}
	Process pro = new Process();
	int contador=0;
	int actualProcess = 0;
	public void run2() {
		
		while (!this.fimEscalonador()) {
			
			for (int x=0;x<processos.size();x++) {
				//System.out.println("rodou "+y);
				if (processos.get(x).getStart() == this.time) {
					pro = processos.get(x);
					pro.setOrder(actualProcess++);
					this.addNovos(pro);
					this.processos.remove(x);
					x--;
				}
			}
			//System.out.println("contador: "+contador);
			if(!isRunning()) {
				if(this.running==null) {
					this.nextRunning();
				}
				else if(this.running.endRun()) {
					//System.out.println("finalizado");
					this.addFinished(running);
					this.nextRunning();
				}else if(exceedRunning()) {
					//System.out.println("excedeu");
					running.setOnRun();
					this.addWaiting(running);
					this.nextRunning();
				}else if(novos.size()>0) {
					running.setOnRun();
					this.addWaiting(running);
					this.nextRunning();
				}
				
			}
			
			if(running!=null) {
				running.decrementRunTime();
				running.incrementOnRun();
				this.running.addFeedback();
				//System.out.println(this.running.getName()+"  "+this.running.getFeedback()+"    "+running.getRuntime());
			}
			this.time++;
			this.allProcess();
			contador++;
			
		}
		this.orderListProcess();
	}
	public void runTesteParte1() {
		for (int x=0;x<processos.size();x++) {
			//System.out.println("rodou "+y);
			if (processos.get(x).getStart() == this.time) {
				pro = processos.get(x);
				pro.setOrder(actualProcess++);
				this.addNovos(pro);
				this.processos.remove(x);
				x--;
			}
		}
	}
	public void runTesteParte2() {
		
		//System.out.println("contador: "+contador);
		if(!isRunning()) {
			if(this.running==null) {
				this.nextRunning();
			}
			else if(this.running.endRun()) {
				//System.out.println("finalizado");
				this.addFinished(running);
				this.nextRunning();
			}else if(exceedRunning()) {
				//System.out.println("excedeu");
				running.setOnRun();
				this.addWaiting(running);
				this.nextRunning();
			}else if(novos.size()>0) {
				running.setOnRun();
				this.addWaiting(running);
				this.nextRunning();
			}
		}
		
		if(running!=null) {
			running.decrementRunTime();
			running.incrementOnRun();
			this.running.addFeedback();
			//System.out.println(this.running.getName()+"  "+this.running.getFeedback()+"    "+running.getRuntime());
		}
		this.time++;
		this.allProcess();
		contador++;
		
	}
	private boolean verificaNovos() {
		if(this.novos.size()>0) {
			return true;
		}return false;
	}
	private boolean verificaWaiting() {
		if(this.waiting.size()>0) {
			return true;
		}return false;
	}
	private void nextProcessNovo() {
		this.running=this.novos.get(0);
		this.running.setStatus("R");
		this.novos.remove(0);
		
	}
	private void nextProcessWaiting() {
		this.running=this.waiting.get(0);
		this.running.setStatus("R");
		this.waiting.remove(0);
		
	}
	private boolean isRunning() {
		if(this.running==null) {
			return false;
		}
		if(this.running.endRun()) {
			return false;
		}
		if(novos.size() > 0) {
			return false;
		}
		if(this.running.getOnRun()<this.quant) {
			return true;
		}
		
		return false;
	}
	private void nextRunning() {
		if(verificaNovos()) {
			nextProcessNovo();
		}else if(verificaWaiting()) {
			nextProcessWaiting();
		}else running=null;
	}
	private boolean exceedRunning() {
		if(running.getOnRun()>this.quant-1) {
			return true;
		}return false;
	}
	
	

}
