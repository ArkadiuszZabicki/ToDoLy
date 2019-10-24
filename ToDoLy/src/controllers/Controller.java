/**
 * 
 * Controller contains methods to control data.
 * It is the only class that has access to classes: Task, Project, ProjectList
 * (except Creator class, that creates new objects from those classes).
 * Methods from this class can access and mutate instances of classes Task, Project, ProjectList
 * 
 */

package controllers;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import classes.Project;
import classes.ProjectList;
import classes.Task;
import java.util.regex.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;


public class Controller {
	
	
	private Project tasklist;
	private ProjectList projectList;
	private Scanner scan;
	
	
	public Controller(ProjectList projectList, Scanner scan) {
		
		this.projectList = projectList;
		this.scan = scan;
		
	}
	
	public boolean isProjectEmpty() {
		
		boolean status = false;
		if(projectList.getProjectList().isEmpty()) {
			status = true;
		}
		
		return status;
	}
	
	/**
	 * Method retrieves all projects in ProjectList instance
	 * using HashMap key() property and prints the outcome
	 **/
	
	public void showTaskListByProject(String idToFind) {
		
		
		
		if(projectList.getProjectList().isEmpty()) {
			System.out.println("List is empty");
		}
		
		
		else {
			
			if(projectList.getProjectList().containsKey(idToFind)) {
				System.out.println("-----");
				projectList.findProject(idToFind).printTaskList();
				System.out.println("-----");
			}
			else {
				System.out.println("Project not found");
		}
		}
		
		
	}
	
	/**
	 * Method shows all projects by date in ProjectList instance
	 * 
	 **/
	
	public void showTaskListByDate(String dateToFind) {
		
		String taskList = "";
		String toReturn = "";
		
		if(projectList.getProjectList().isEmpty()) {
			System.out.println("List is empty");
		}
		else {
			
			for(Project i : projectList.getProjectList().values()) {
				
				for(Task j : i.getTaskList().values()) {
					
					if(j.getDate().equals(dateToFind)) {
						taskList += (j.getId() + " " + j.getTask() + " " + j.getDate() + " " + j.getStatus() + "\n");
					}
					
				}
				
			}
			
			
			if(taskList.length() > 0) {
				
				toReturn = taskList;
			}
			else {
				
				toReturn = "Date not found";
			}
		}
		System.out.println(toReturn);
	}
	
	/**
	 * Method checks if project is present in ProjectList instance
	 * @param id
	 * @return project (or null if project not found)
	 */
	
	public Project findProject(String id) {
		
		Project tmpProject;
		
		if(projectList.getProjectList().containsKey(id)) {
			
			tmpProject = projectList.findProject(id);
			
		}
		
		else {
			
			System.out.println("Project not found");
			tmpProject = null;
			
		}
		
		return tmpProject;
		
		
	}
	
	/**
	 * Method changes state of Task field "status". User can mark tasks that are already done.
	 * @param id 
	 * @param chooseProject
	 */
	
	public void markAsDone(String id, String chooseProject) {
		
		Project tmpProj = projectList.getProjectList().get(chooseProject);
		if(this.taskInProject(id, chooseProject)) {
			
			Task tmpTask = tmpProj.findTask(id);
			
			tmpTask.setStatus("Done");
			System.out.println("Task " + id + " marked as done");
			
		}
		else {
			System.out.println("There is no such task. Pick task from the list.");
			
		}
	}
	
	/**
	 * Method removes task from a Project instance.
	 * @param id
	 * @param chooseProject
	 */
	
	public void removeTask(String id, String chooseProject) {
		
		Project tmpProj = projectList.getProjectList().get(chooseProject);
		
		if(this.taskInProject(id, chooseProject)) {
			tmpProj.removeTask(id);
			
			System.out.println("Task removed");
		}
		
		else {
			System.out.println("There is no such task. Pick task from the list.");
		}
		
		
	}
	
	/**
	 * Method allows user to change task name, if necessary.
	 * @param id
	 * @param chooseProject
	 * @throws IOException
	 */
	
	public void changeTaskName(String id, String chooseProject) throws IOException {
		
		Project tmpProj = projectList.getProjectList().get(chooseProject);
		Task tmpTask = tmpProj.findTask(id);
		System.out.println("Type a new task name");
		String newTask = Parser.getStringInput(scan);
		
		tmpTask.setTask(newTask);
	}
	
	/**
	 * Method allows user to change due date, if necessary.
	 * @param id
	 * @param chooseProject
	 * @throws IOException
	 */
	
	public void changeDueDate(String id, String chooseProject) throws IOException {
		
		Project tmpProj = projectList.getProjectList().get(chooseProject);
		Task tmpTask = tmpProj.findTask(id);
		System.out.println("Type a new due date");
		String newDate = Parser.getStringInput(scan);
		
		tmpTask.setDate(this.checkDateFormat(newDate));
	}
	
	/**
	 * Method checks if a task is present in a project.
	 * @param id
	 * @param chooseProject
	 * @return true if task is in project, false if there is no such task
	 */
	
	public boolean taskInProject(String id, String chooseProject) {
		
		boolean inTheProject;
		Project tmpProj = projectList.getProjectList().get(chooseProject);
		if(tmpProj.getTaskList().containsKey(id)) {
			inTheProject = true;
		}
		else {
			inTheProject = false;
		}
		return inTheProject;
		
		
	}
	
	/**
	 * Method prints all project added to project list.
	 */
	public void showAllProjects() {
		System.out.println(projectList.saveAllProjects());
	}
	
	/**
	 * Method returns all projects in project list. It's used to save data to a file.
	 * @return String with all projects, that will be saved in a file.
	 */
	
	public String allProjects() {
		return projectList.showAllProjects();
	}
	
	/**
	 * Method checks if project is present in a project list.
	 * @param id
	 * @return true if project is in project list, false if there is no such project
	 */
	
	public boolean projectInProjectList(String id) {
		boolean inTheProjectList;
		if(projectList.getProjectList().containsKey(id)) {
			inTheProjectList = true;
		}
		else {
			inTheProjectList = false;
		}
		return inTheProjectList;
	}
	
	
	public String listToSave() {
		
		String toReturn = projectList.saveAllProjects();
		return toReturn;
		
	}
	
	/**
	 * Method retrieves all tasks with "Undone" status.
	 * @return integer with number of tasks with "Udnone" status
	 */
	
	public String getUndoneTasks() {
		
		int undoneCount = 0;
		
		for(Project i : projectList.getProjectList().values()) {
			
			for(Task j : i.getTaskList().values()) {
				
				if(j.getStatus().equals("Undone")) {
					undoneCount ++;
				}
				
			}
			
		}
		
		return Integer.toString(undoneCount);
		
	}
	
	/**
	 * Retrieves all tasks with "Done" status.
	 * @return integer with number of all tasks with "Done" status
	 */
	
public String getDoneTasks() {
		
		int doneCount = 0;
		
		for(Project i : projectList.getProjectList().values()) {
			
			for(Task j : i.getTaskList().values()) {
				
				if(j.getStatus().equals("Done")) {
					doneCount ++;
				}
				
			}
			
		}
		
		return Integer.toString(doneCount);
		
	}

/**
 * Method checks if a date input has a valid format.
 * @param date
 * @return String with date
 * @throws IOException
 */

public String checkDateFormat(String date) throws IOException {
	
	String newDate = "";
	
	while(!Parser.checkDate(date)) {
		System.out.println("This isn't valid date format. Try MM/dd/yyyy");
		date = Parser.getStringInput(scan);
	}
	
	
	
	newDate = this.checkTheDate(date);
	
	return newDate;
}

/**
 * Method checks if date is before present day. 
 * It's purpose is to make sure that all tasks added to project
 * are up to date
 * @param date
 * @return String with date
 * @throws IOException
 */

public String checkTheDate(String date) throws IOException {
	
	String newDate = "";
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	LocalDate ParsedDate = LocalDate.parse(date, formatter);
	while(!Parser.isBeforeNow(ParsedDate)) {
		System.out.println("You cannot add task with date from the past");
		date = Parser.getStringInput(scan);
		ParsedDate = LocalDate.parse(date, formatter);
	}
	
	newDate = ParsedDate.format(formatter).toString();
	return newDate;
	
}



/**
 * 
 * Unused methods for sorting HashMaps
 * 
 * public void sortByProject() {
	
	Map<String,Project> sortedMap = 
            new TreeMap<String,Project>(new Comparator<String>()
    {
        @Override
        public int compare(String i1, String i2)
        {
            return i1.compareTo(i2);
        }
    }
            );
	
	sortedMap.putAll(projectList.getProjectList());
	printMap(sortedMap);
}

public static void printMap(Map<String, Project> map) {
	System.out.println("**************************************");
    for (Map.Entry<String, Project> entry : map.entrySet()) {
        System.out.println("Key : " + entry.getKey() 
                                  + " Value : " + entry.getValue());
    }
    System.out.println();
}
 * 
 * 
 */

/**
 * Method sorts all projects by project and prints them in ascending order.
 */

public void sortByProject() {
	
	ArrayList<String> sorted = new ArrayList<String>();
	
	for(Project i : projectList.getProjectList().values()) {
		for(Task j : i.getTaskList().values()) {
			String arrListElem = i.getId() + ", " + j.getDate() + ", " + j.getTask() + ", " + j.getStatus();
			sorted.add(arrListElem);
		}
	}
	
	Collections.sort(sorted);
	for(String i : sorted) {
		System.out.println(i);
	}
}

/**
 * Method sorts all projects by date and prints them in ascending order.
 */

public void sortByDate() {
	
	ArrayList<String> sorted = new ArrayList<String>();
	
	for(Project i : projectList.getProjectList().values()) {
		for(Task j : i.getTaskList().values()) {
			String arrListElem = j.getDate() + ", " + i.getId() + ", " + j.getTask() + ", " + j.getStatus();
			sorted.add(arrListElem);
		}
	}
	
	Collections.sort(sorted);
	for(String i : sorted) {
		System.out.println(i);
	}
}

/**
 * Method checks how many tasks has due date for a present day.
 * @return integer with a number of tasks with present's day due date.
 */

public int tasksForToday() {
	
	int tasksForTodayInt = 0;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	LocalDate now = LocalDate.now();
	for(Project i : projectList.getProjectList().values()) {
		for(Task j : i.getTaskList().values()) {
			if(LocalDate.parse(j.getDate(), formatter).isEqual(now) && j.getStatus().equals("Undone")) {
				tasksForTodayInt ++;
				
			}
		}
	}
	
	
	return tasksForTodayInt;
	
}

/**
 * Method return all tasks with present's day due date
 * @return String with tasks that should be done today.
 */

public String printTasksForToday() {
	
	String tasksForToday = "";
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	LocalDate now = LocalDate.now();
	for(Project i : projectList.getProjectList().values()) {
		for(Task j : i.getTaskList().values()) {
			if(LocalDate.parse(j.getDate(), formatter).isEqual(now) && j.getStatus().equals("Undone")) {
				tasksForToday +="Project " + i.getId() + ": " + j.getTask() + ", " + j.getStatus() + "\n";
				
			}
		}
	}
	
	return tasksForToday;
}

/**
 * Method checks, how many tasks expired, which means their due date is before present day.
 * @return integer with amount of expired tasks.
 */

public int expiredTasksInt() {
	
	int expiredTasks = 0;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	LocalDate now = LocalDate.now();
	for(Project i : projectList.getProjectList().values()) {
		for(Task j : i.getTaskList().values()) {
			if(LocalDate.parse(j.getDate(), formatter).isBefore(now) && j.getStatus().equals("Undone")) {
				expiredTasks ++;
			}
		}
	}
	return expiredTasks;
	
}

/**
 * Method returns all tasks that are expired.
 * @return String with all tasks, that are expired
 */

public String expiredTasksList() {
	
	String expiredTasks = "";
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	LocalDate now = LocalDate.now();
	for(Project i : projectList.getProjectList().values()) {
		for(Task j : i.getTaskList().values()) {
			if(LocalDate.parse(j.getDate(), formatter).isBefore(now) && j.getStatus().equals("Undone")) {
				expiredTasks += "Project " + i.getId() + ": " + j.getTask() + ", " + j.getDate() + "\n";
			}
		}
	}
	return expiredTasks;
	
}

/**
 * Method creates a message for a welcome menu, contain the amount of expired tasks.
 * @return message with amount of expired tasks, displayed in welcome menu.
 */

public String expiredTasksMenu() {
	
	String message = "";
	if(this.expiredTasksInt() > 0) {
		message += ">> " + Integer.toString(this.expiredTasksInt()) + " of your tasks expired. Check them immediately!";
	}
	else {
		message += ">> None of your tasks has expired yet.";
	}
	
	return message;
}

/**
 * Method returns next id from given project. This ID is used then while creating new tasks.
 * @param projectId
 * @return
 */

public int nextId(String projectId) {
	
	int nextId = 0;
	
	
		
	nextId = projectList.getProjectList().get(projectId).getNextId();
	
	
	
	return nextId + 1;
}

}



 

