import org.junit.Test;
import static org.junit.Assert.*;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("123", "Test Task", "This is a test task description");
        assertEquals("123", task.getTaskId());
        assertEquals("Test Task", task.getName());
        assertEquals("This is a test task description", task.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskIdTooLong() {
        new Task("12345678901", "Test Task", "This is a test task description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskIdNull() {
        new Task(null, "Test Task", "This is a test task description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNameTooLong() {
        new Task("123", "This name is too long to be valid", "This is a test task description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNameNull() {
        new Task("123", null, "This is a test task description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDescriptionTooLong() {
        new Task("123", "Test Task", "This description is way too long to be valid according to the requirements and should throw an exception");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDescriptionNull() {
        new Task("123", "Test Task", null);
    }

    @Test
    public void testSetName() {
        Task task = new Task("123", "Test Task", "This is a test task description");
        task.setName("Updated Task");
        assertEquals("Updated Task", task.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNameTooLong() {
        Task task = new Task("123", "Test Task", "This is a test task description");
        task.setName("This name is too long to be valid");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNameNull() {
        Task task = new Task("123", "Test Task", "This is a test task description");
        task.setName(null);
    }

    @Test
    public void testSetDescription() {
        Task task = new Task("123", "Test Task", "This is a test task description");
        task.setDescription("Updated description");
        assertEquals("Updated description", task.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDescriptionTooLong() {
        Task task = new Task("123", "Test Task", "This is a test task description");
        task.setDescription("This description is way too long to be valid according to the requirements and should throw an exception");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDescriptionNull() {
        Task task = new Task("123", "Test Task", "This is a test task description");
        task.setDescription(null);
    }

    @Test
    public void testTaskIdMaxLength() {
        Task task = new Task("1234567890", "Test Task", "This is a test task description");
        assertEquals("1234567890", task.getTaskId());
    }

    @Test
    public void testNameMaxLength() {
        Task task = new Task("123", "12345678901234567890", "This is a test task description");
        assertEquals("12345678901234567890", task.getName());
    }

    @Test
    public void testDescriptionMaxLength() {
        Task task = new Task("123", "Test Task", "12345678901234567890123456789012345678901234567890");
        assertEquals("12345678901234567890123456789012345678901234567890", task.getDescription());
    }
}
