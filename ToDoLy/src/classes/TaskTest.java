/**
 * 
 */
package classes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author arkadiuszzabicki
 *
 */
class TaskTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link classes.Task#getId()}.
	 */
	@Test
	void testGetId() {
		String id = "1234";
		Task task = new Task();
		task.setId(id);
		String actual = task.getId();
		String expected = "1234";
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link classes.Task#getTask()}.
	 */
	@Test
	void testGetTask() {
		String taskName = "Buy milk";
		Task task = new Task();
		task.setTask(taskName);
		String actual = task.getTask();
		String expected = "Buy milk";
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link classes.Task#getDate()}.
	 */
	@Test
	void testGetDate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link classes.Task#setId(java.lang.String)}.
	 */
	@Test
	void testSetId() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link classes.Task#setTask(java.lang.String)}.
	 */
	@Test
	void testSetTask() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link classes.Task#setDate(java.lang.String)}.
	 */
	@Test
	void testSetDate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link classes.Task#setStatus(java.lang.String)}.
	 */
	@Test
	void testSetStatus() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link classes.Task#getStatus()}.
	 */
	@Test
	void testGetStatus() {
		fail("Not yet implemented");
	}

}
