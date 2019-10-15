package classes;

public class Task {
	
	private String id;
	private String task;
	private String date;
	private String status;
	
	public Task(String id, String task, String date) {
		this.id = id;
		this.task = task;
		this.date = date;
		this.status = "Undone";
	}
	
	public Task() {
		
		
	}
	
	public String getId() {
		return id;
	}
	
	public String getTask() {
		return task;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setTask(String task) {
		this.task = task;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
}
