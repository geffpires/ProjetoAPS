package Escalonador;

public class Process {
	
	private String name;
	private int start;
	private int runtime;
	private char status;
	private int onRun;
	private String feedback = "";
	
	public Process(String name, int start, int runtime, int onRun) {
		super();
		this.name = name;
		this.start = start;
		this.runtime = runtime;
		this.onRun = onRun;
	}

	public String getName() {
		return name;
	}

	public int getStart() {
		return start;
	}

	public int getRuntime() {
		return runtime;
	}
	
	public void setRunTime() {
		this.runtime--;
		if (this.runtime == 0) {
			this.setStatus('F');
		}
		this.addFeedback(this.getStatus());
	}
	public int getOnRun() {
		return this.onRun;
	}
	
	public void sairDoEscalonador(Escalonador e) {
		if (this.getOnRun() == e.getQuant()) {
			//ir pro final da lista de waiting
		}
	}

	public String getFeedback() {
		return feedback;
	}
	
	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public void addFeedback(char statusRun) {
		this.feedback += statusRun;
	}

}
