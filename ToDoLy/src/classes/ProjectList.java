package classes;
import java.util.HashMap;


public class ProjectList {

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
	
	public String saveAllProjects() {
		
		String toSave = "";
		for(Project i : projectList.values()) {
			for(Task j : i.getTaskList().values()) {
				toSave += (i.getId() + " " + j.getTask() + " " + j.getDate() + " " + j.getStatus() + "\n");
			}
		}
		return toSave;
	}
	
}
