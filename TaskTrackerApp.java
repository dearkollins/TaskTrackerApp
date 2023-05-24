import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private String title;
    private String description;
    private boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void completeTask() {
        completed = true;
    }
}

class TaskTracker {
    private List<Task> tasks;

    public TaskTracker() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void displayTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            String status = task.isCompleted() ? "Completed" : "Not Completed";
            System.out.println((i + 1) + ". " + task.getTitle() + " - " + task.getDescription() + " [" + status + "]");
        }
    }

    public void completeTask(int taskIndex) {
        if (taskIndex >= 1 && taskIndex <= tasks.size()) {
            Task task = tasks.get(taskIndex - 1);
            task.completeTask();
            System.out.println("Task \"" + task.getTitle() + "\" marked as completed.");
        } else {
            System.out.println("Invalid task index.");
        }
    }
}

public class TaskTrackerApp {
    public static void main(String[] args) {
        TaskTracker taskTracker = new TaskTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("TaskTrackerApp Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Display Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    Task task = new Task(title, description);
                    taskTracker.addTask(task);
                    System.out.println("Task added successfully.");
                    break;
                case 2:
                    taskTracker.displayTasks();
                    break;
                case 3:
                    System.out.print("Enter the task index to mark as completed: ");
                    int taskIndex = scanner.nextInt();
                    taskTracker.completeTask(taskIndex);
                    break;
                case 4:
                    System.out.println("Exiting TaskTrackerApp. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
