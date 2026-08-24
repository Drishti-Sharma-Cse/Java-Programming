import java.util.ArrayList;
import java.util.Scanner;

// A simple class to represent a single daily task or problem
class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false; // Tasks are incomplete by default
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markComplete() {
        this.isCompleted = true;
    }
}

public class DailyPlanner {
    public static void main(String[] args) {
        // Dynamic list to store daily problems/tasks
        ArrayList<Task> taskList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Daily Planner & Problem Tracker ===");
        
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. View Daily Tasks");
            System.out.println("2. Add New Task/Problem");
            System.out.println("3. Mark Task as Solved/Complete");
            System.out.println("4. Clear All Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left behind by nextInt()
            
            switch (choice) {
                case 1:
                    // View Tasks
                    System.out.println("\n--- Your Tasks For Today ---");
                    if (taskList.isEmpty()) {
                        System.out.println("[No tasks added yet. Your day is clear!]");
                    } else {
                        for (int i = 0; i < taskList.size(); i++) {
                            Task currentTask = taskList.get(i);
                            String status = currentTask.isCompleted() ? "[✓] Solved" : "[ ] Pending";
                            System.out.printf("%d. %s - %s%n", (i + 1), currentTask.getDescription(), status);
                        }
                    }
                    break;
                    
                case 2:
                    // Add Task
                    System.out.print("Enter the task or problem description: ");
                    String description = scanner.nextLine();
                    if (!description.trim().isEmpty()) {
                        taskList.add(new Task(description));
                        System.out.println("Task added successfully!");
                    } else {
                        System.out.println("Task description cannot be empty.");
                    }
                    break;
                    
                case 3:
                    // Mark Task as Complete
                    if (taskList.isEmpty()) {
                        System.out.println("No tasks available to mark complete.");
                        break;
                    }
                    System.out.print("Enter the task number to mark complete: ");
                    int taskNum = scanner.nextInt();
                    
                    // Validate if the number entered matches a real task index
                    if (taskNum > 0 && taskNum <= taskList.size()) {
                        Task taskToComplete = taskList.get(taskNum - 1);
                        taskToComplete.markComplete();
                        System.out.printf("'%s' marked as solved! Great job.%n", taskToComplete.getDescription());
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;
                    
                case 4:
                    // Clear List
                    taskList.clear();
                    System.out.println("All tasks have been cleared for the day.");
                    break;
                    
                case 5:
                    // Exit
                    System.out.println("Goodbye! Have a productive day ahead.");
                    isRunning = false;
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please pick an option between 1 and 5.");
            }
        }
        
        scanner.close();
    }
}


