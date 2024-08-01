package CTS_Weekly_Exercies.Week1_DSA.Task_management_system;

public class Main {
    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();
       // assigning some sample tasks
        Task task1 = new Task(1, "Task 1", "In Progress");
        Task task2 = new Task(2, "Task 2", "Completed");
        Task task3 = new Task(3, "Task 3", "Pending");

        tms.addTask(task1);
        tms.addTask(task2);
        tms.addTask(task3);

        tms.traverseTasks();

        Task foundTask = tms.searchTask(2);
        if (foundTask != null) {
            System.out.println("Found task: " + foundTask.getTaskName());
        } else {
            System.out.println("Task not found");
        }

        tms.deleteTask(2);
        tms.traverseTasks();
    }
}
