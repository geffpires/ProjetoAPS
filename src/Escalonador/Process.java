package Escalonador;

public class Process {
	
	private String name;
	private int start;
	private int runtime;
	private char status;
	private int onRun = 0;
	private String feedback = "";
	
	public Process(String name, int start, int runtime) {
		this.name = name;
		this.start = start;
		this.runtime = runtime;
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
	
	// isso ja vai ser feito no escalonador
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
	
	public boolean 

}
