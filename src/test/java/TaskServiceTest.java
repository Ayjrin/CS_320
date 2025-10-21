import org.junit.Test;

public class TaskServiceTest {

    @Test
    public void testAddTask() {
        TaskService service = new TaskService();
        Task task = new Task("123", "Test Task", "This is a test task description");
        // Should not throw exception when adding valid task
        service.addTask(task);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateTask() {
        TaskService service = new TaskService();
        Task task1 = new Task("123", "Test Task", "This is a test task description");
        Task task2 = new Task("123", "Another Task", "This is another test task description");
        service.addTask(task1);
        service.addTask(task2);
    }

    @Test
    public void testDeleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("123", "Test Task", "This is a test task description");
        service.addTask(task);
        // Should not throw exception when deleting existing task
        service.deleteTask("123");
    }

    @Test
    public void testDeleteNonExistentTask() {
        TaskService service = new TaskService();
        // Should not throw exception when deleting non-existent task
        service.deleteTask("nonexistent");
    }

    @Test
    public void testUpdateName() {
        TaskService service = new TaskService();
        Task task = new Task("123", "Test Task", "This is a test task description");
        service.addTask(task);
        // Should not throw exception when updating existing task
        service.updateName("123", "Updated Task");
    }

    @Test
    public void testUpdateNameNonExistentTask() {
        TaskService service = new TaskService();
        // Should not throw exception when updating non-existent task
        service.updateName("nonexistent", "Updated Task");
    }

    @Test
    public void testUpdateDescription() {
        TaskService service = new TaskService();
        Task task = new Task("123", "Test Task", "This is a test task description");
        service.addTask(task);
        // Should not throw exception when updating existing task
        service.updateDescription("123", "Updated description");
    }

    @Test
    public void testUpdateDescriptionNonExistentTask() {
        TaskService service = new TaskService();
        // Should not throw exception when updating non-existent task
        service.updateDescription("nonexistent", "Updated description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateNameWithInvalidData() {
        TaskService service = new TaskService();
        Task task = new Task("123", "Test Task", "This is a test task description");
        service.addTask(task);
        service.updateName("123", "This name is too long to be valid");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateDescriptionWithInvalidData() {
        TaskService service = new TaskService();
        Task task = new Task("123", "Test Task", "This is a test task description");
        service.addTask(task);
        service.updateDescription("123", "This description is way too long to be valid according to the requirements and should throw an exception");
    }
}