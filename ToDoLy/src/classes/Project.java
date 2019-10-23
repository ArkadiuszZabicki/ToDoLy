/**
 * Project contains all tasks in a form of HashMap
 * It takes unique Id and a task as a parameter
 * Methods can be used to add, retrieve or remove singular tasks.
 */

package classes;
import java.util.HashMap;


public class Project {
	
	private String id;
	private String date;
	
	HashMap<String,Task> taskList;
	
	public Project(String id) {
		this.id = id;
		setTaskList(new HashMap<String, Task>());
	}
	
	public void setTaskList(HashMap<String, Task> tasklist) {
		this.taskList = tasklist;
	}
	
	public HashMap<String, Task> getTaskList(){
		return taskList;
	}
	
	public void addTask(Task task) {
		getTaskList().put(task.getId(), task);
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	public Task findTask(String id) {
		return taskList.get(id);
	}
	
	public void removeTask(String id) {
		taskList.remove(id);
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}
	
	public void printTaskList() {
		for(Task i : taskList.values()) {
			System.out.println(i.getId() + " " + i.getTask() + " " + i.getDate() + " " + i.getStatus());
		}
	}
}
