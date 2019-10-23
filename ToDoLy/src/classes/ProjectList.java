/**
 * 
 * Class ProjectList stores all projects in a HashMap
 * Contains methods to add and retrieve projects
 * 
 * 
 */

package classes;
import java.util.HashMap;


public class ProjectList  {

	HashMap<String, Project> projectList;
	
	public ProjectList() {
		setProjectList(new HashMap<String, Project>());
	}
	
	public void setProjectList(HashMap<String, Project> projectList) {
		this.projectList = projectList;
	}
	
	public HashMap<String, Project> getProjectList(){
		return projectList;
	}
	
	public void addProject(Project project) {
		getProjectList().put(project.getId(), project);
	}
	
	public Project findProject(String id) {
		return projectList.get(id);
	}
	
	/**
	 * saveAllProjects retrieves all date necessary for a save file purposes.
	 * @return String with all data saved in a file
	 */
	public String saveAllProjects() {
		
		String toSave = "";
		for(Project i : projectList.values()) {
			for(Task j : i.getTaskList().values()) {
				toSave += (i.getId() + ";" + j.getId() + ";" + j.getTask() + ";" + j.getDate() + ";" + j.getStatus() + "\n");
			}
		}
		return toSave;
	}
	
	/**
	 * showAllProjects retrieves all projects added to HashMap
	 * @return String with all projects
	 */
	public String showAllProjects() {
		String allProjects = "";
		for(Project i : projectList.values()) {
			allProjects += i.getId() + "\n";
		}
		return allProjects;
	}
	
}
