package ui;

import model.Task;
import service.TaskService;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private TaskService taskService;

    public Menu(TaskService taskService) {
        this.taskService = taskService;
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        int option;

        do {
            showMenu();
            option = scanner.nextInt();

            switch (option){
                case 1:
                    handleAddTask();
                    break;
                case 2:
                    handleListTasks();
                    break;
                case 3:
                    handleFindTaskById();
                    break;
                case 4:
                    handleMarkTaskAsCompleted();
                    break;
                case 5:
                    handleDeleteTask();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid option");
            }

        } while (option != 6);

        System.out.println("Exiting app...");
    }

    public void showMenu(){
        System.out.println("1. Add task ");
        System.out.println("2. List tasks ");
        System.out.println("3. Find task by id ");
        System.out.println("4. Mark task as completed ");
        System.out.println("5. Delete task ");
        System.out.println("6. Exit ");

    }
    public void handleAddTask(){
        System.out.println("Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Title: ");
        String title = scanner.nextLine();
        System.out.println("Description: ");
        String description = scanner.nextLine();
        taskService.addTask(id,title,description);
        System.out.println("Task added successfully");
    }
    public void handleListTasks(){
        ArrayList<Task> tasks = taskService.getTasks();

        if (tasks.isEmpty()) {
            System.out.println("Empty list");
        } else {
            for (Task task : tasks){
                System.out.println(task);
            }
        }
    }
    public void handleFindTaskById(){
        System.out.println("Id: ");
        int id = scanner.nextInt();
        Task task = taskService.findTaskById(id);
        if (task == null) {
            System.out.println("Task not found");
        } else {
            System.out.println(task);
        }
    }
    public void handleMarkTaskAsCompleted(){
        System.out.println("Id: ");
        int id = scanner.nextInt();
        if (taskService.markTaskAsCompleted(id)) {
            System.out.println("Task marked as completed");
        } else {
            System.out.println("Task not found");
        }
    }
    public void handleDeleteTask(){
        System.out.println("Id: ");
        int id = scanner.nextInt();
        if (taskService.deleteTask(id)) {
            System.out.println("Task deleted successfully");
        } else {
            System.out.println("Task not found");
        }
    }
}
