/**
 * Project contains all tasks in a form of HashMap
 * It takes unique Id and a task as a parameter
 * Methods can be used to add, retrieve or remove singular tasks.
 */

package classes;
import java.util.HashMap;


public class Project {
	
	private String id;
	private int nextId;
	
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
		this.nextId ++;
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
		this.nextId --;
	}
	
	public int getNextId() {
		return nextId;
	}
	
	public void printTaskList() {
		for(Task i : taskList.values()) {
			System.out.println(i.getId() + " " + i.getTask() + " " + i.getDate() + " " + i.getStatus());
		}
	}
}
