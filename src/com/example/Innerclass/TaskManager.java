package com.example.Innerclass;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<User> users;
    private List<Task> tasks;

    public TaskManager() {
        users = new ArrayList<>();
        tasks = new ArrayList<>();
    }

    // Inner class for managing users
    public class UserManager {
        public void addUser(String username) {
            User newUser = new User(username);
            users.add(newUser);
            System.out.println("User added: " + newUser.getUsername());
        }

        public void displayUsers() {
            System.out.println("\n--- List of Users ---");
            for (User user : users) {
                System.out.println(user.getUsername());
            }
        }
    }

    // Inner class for managing tasks
    public class TaskManagerInner {
        public void addTask(String title, String description) {
            Task newTask = new Task(title, description);
            tasks.add(newTask);
            System.out.println("Task added: " + newTask.getTitle() + " - " + newTask.getDescription());
        }

        public void displayTasks() {
            System.out.println("\n--- List of Tasks ---");
            for (Task task : tasks) {
                String status = task.isCompleted() ? "Completed" : "Not Completed";
                System.out.println(task.getTitle() + " - " + task.getDescription() + " (" + status + ")");
            }
        }

        public void markTaskAsCompleted(int index) {
            if (index >= 0 && index < tasks.size()) {
                Task task = tasks.get(index);
                task.markAsCompleted();
                System.out.println("Task marked as completed: " + task.getTitle());
            } else {
                System.out.println("Invalid task index");
            }
        }
    }
    
    public static void main(String[] args) {
        // Creating an instance of the TaskManager
        TaskManager taskManager = new TaskManager();

        // Creating instances of inner classes to manage users and tasks
        TaskManager.UserManager userManager = taskManager.new UserManager();
        TaskManager.TaskManagerInner taskManagerInner = taskManager.new TaskManagerInner();

        // Adding users and displaying them
        userManager.addUser("Alice");
        userManager.addUser("Bob");
        userManager.displayUsers();

        // Adding tasks, displaying them, and marking one as completed
        taskManagerInner.addTask("Java Project", "Create a small Java project");
        taskManagerInner.addTask("Write Report", "Write a report on the project");
        taskManagerInner.displayTasks();
        taskManagerInner.markTaskAsCompleted(0);
        taskManagerInner.displayTasks();
    }
}