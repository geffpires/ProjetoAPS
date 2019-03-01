package Escalonador;

public class Process {
	
	private String name;
	private int start;
	private int runtime;
	private String status;
	private int onRun = 0;
	private String feedback = "";
	
	public Process(String name, int start, int runtime) {
		this.name = name;
		this.start = start;
		this.runtime = runtime;
	}



	public Process() {
		// TODO Auto-generated constructor stub
	}


	public void incrementOnRun() {
		this.onRun++;
	}
	public void decrementRunTime() {
		this.runtime--;
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
	
	public int getOnRun() {
		return this.onRun;
	}
	
	public String getFeedback() {
		return feedback;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void addFeedback() {
		this.feedback += this.getStatus();
	}
	
	public boolean endRun() {
		if (runtime <= 0) {
			return true;
		}
		return false;
	}



	public void setOnRun() {
		this.onRun = 0;
		// TODO Auto-generated method stub
		
	}

}
