package WeekOne.Collections;

import java.util.LinkedList;
import java.util.Queue;

public class TaskQueueManager {
    private Queue<String> taskQueue;

    // Constructor
    public TaskQueueManager() {
        taskQueue = new LinkedList<>();
    }

    // Method to add a task to the queue
    public void enqueueTask(String task) {
        taskQueue.offer(task);
        System.out.println("Task '" + task + "' added to the queue.");
    }

    // Method to process (remove and return) the next task from the queue
    public String dequeueTask() {
        String nextTask = taskQueue.poll();
        if (nextTask != null) {
            System.out.println("Task '" + nextTask + "' removed from the queue.");
        } else {
            System.out.println("No tasks in the queue.");
        }
        return nextTask;
    }

    // Method to display all tasks in the queue
    public void displayTasks() {
        System.out.println("Tasks in the queue:");
        for (String task : taskQueue) {
            System.out.println("- " + task);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a TaskQueueManager object
        TaskQueueManager queueManager = new TaskQueueManager();

        // Add some tasks to the queue
        queueManager.enqueueTask("Task 1");
        queueManager.enqueueTask("Task 2");
        queueManager.enqueueTask("Task 3");

        // Display all tasks in the queue
        queueManager.displayTasks();

        // Process (dequeue) tasks from the queue
        String task = queueManager.dequeueTask();
        System.out.println("Processed task: " + task);

        // Display updated tasks in the queue
        queueManager.displayTasks();
    }
}

