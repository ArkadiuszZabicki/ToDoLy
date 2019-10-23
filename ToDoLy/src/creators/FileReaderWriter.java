/**
 * FileReaderWriter class handles cases of writing data to file
 * and reading data from file.
 */

package creators;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import controllers.Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

public class FileReaderWriter {
	
	
	private static final String filePath = "/Users/arkadiuszzabicki/git/ToDoLy/ToDoLy/ToDoLy.txt";
	private File file;
	private BufferedReader bread;
	private InputStreamReader isr;
	private BufferedWriter bwrite;
	private FileOutputStream fwrite;
	private Creator creator;
	private Controller controller;
	
	public FileReaderWriter(BufferedReader bread, InputStreamReader isr, Creator creator, Controller controller) {
		this.bread = bread;
		this.isr = isr;
		this.creator = creator;
		this.controller = controller;
	}
	
	
	/**
	 * Method creates a new text file in a given path.
	 * @throws IOException
	 */
	
	public static void createNewFile() throws IOException {
		File newFile = new File(filePath);
		newFile.createNewFile();
	}
	
	/**
	 * Method saves String given as a parameter to a text file in a given path.
	 * @param fileToSave
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	
	public void saveToFile(String fileToSave) throws UnsupportedEncodingException, FileNotFoundException, IOException {
		
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
	              new FileOutputStream("ToDoLy.txt"), "utf-8"))) {
	   writer.write(fileToSave);
	}
		
	}
	
	/**
	 * Method reads a file from a path.
	 * Each line is split and elements of that split are used to create objects: projects and tasks.
	 * @throws IOException
	 */
	
	public void readFromFile() throws IOException {
		
		File file = new File(filePath); 
		
		  
		if(!file.exists()) {
			FileReaderWriter.createNewFile();
		}
		else {
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			String st; 
			while ((st = br.readLine()) != null) {
				String[] split = st.split(";");
				if(controller.projectInProjectList(split[0])){
					creator.addTaskFromFile(split[1], split[2], split[3], split[4], split[0]);
				}
				else {
					creator.addProjectFromFile(split[0]);
					creator.addTaskFromFile(split[1], split[2], split[3], split[4], split[0]);
				}
				
				
				
			}
		}
		  
		
	}
	
	
	
}
