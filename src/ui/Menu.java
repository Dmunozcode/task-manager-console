package ui;

import model.Priority;
import model.Task;
import service.TaskService;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final TaskService taskService;

    public Menu(TaskService taskService) {
        this.taskService = taskService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int option;

        do {
            showMenu();
            option = readInt();

            switch (option) {
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
                    handleFilterByPriority();
                    break;
                case 7:
                    handleFilterByStatus();
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Invalid option");
            }

        } while (option != 8);

        System.out.println("Exiting app...");
    }

    private void showMenu() {
        System.out.println("1. Add task ");
        System.out.println("2. List tasks ");
        System.out.println("3. Find task by id ");
        System.out.println("4. Mark task as completed ");
        System.out.println("5. Delete task ");
        System.out.println("6. Filter by priority");
        System.out.println("7. Filter by status");
        System.out.println("8. Exit ");
    }
    private void handleAddTask() {
        System.out.println("Id: ");
        int id = readInt();
        System.out.println("Title: ");
        String title = readNonEmptyText();
        System.out.println("Description: ");
        String description = readNonEmptyText();
        System.out.println("Priority: ");
        Priority priority = readPriority();
        if(taskService.addTask(id, title, description, priority)) {
            System.out.println("Task added successfully");
        } else {
            System.out.println("Task ID already exists");
        }
    }
    private void handleListTasks() {
        displayTasks(taskService.getTasks());
    }
    private void handleFindTaskById() {
        System.out.println("Id: ");
        int id = readInt();
        Task task = taskService.findTaskById(id);
        if (task == null) {
            System.out.println("Task not found");
        } else {
            System.out.println(task);
        }
    }
    private void handleMarkTaskAsCompleted() {
        System.out.println("Id: ");
        int id = readInt();
        if (taskService.markTaskAsCompleted(id)) {
            System.out.println("Task marked as completed");
        } else {
            System.out.println("Task not found");
        }
    }
    private void handleDeleteTask() {
        System.out.println("Id: ");
        int id = readInt();
        if (taskService.deleteTask(id)) {
            System.out.println("Task deleted successfully");
        } else {
            System.out.println("Task not found");
        }
    }
    private void handleFilterByPriority() {
        System.out.println("Priority (LOW, MEDIUM, HIGH): ");
        Priority priority = readPriority();

        List<Task> filteredTasks =
                taskService.filterByPriority(priority);

        displayTasks(filteredTasks);
    }
    private void handleFilterByStatus() {
        System.out.println("1. Completed tasks");
        System.out.println("2. Pending tasks");

        int option = readInt();

        if(option == 1){
            displayTasks(taskService.filterByStatus(true));
        } else if (option == 2) {
            displayTasks(taskService.filterByStatus(false));
        } else {
            System.out.println("Invalid option");
        }
    }
    private int readInt() {
        while (true) {
            String input = scanner.nextLine();

            if (input.isBlank()) {
                System.out.println("Input cannot be empty. Try again");
                continue;
            }
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e){
                System.out.println("Invalid number. Try again. ");
            }
        }
    }
    private String readNonEmptyText() {
        while(true){
            String text = scanner.nextLine();

            if(!text.isBlank()){
                return text;
            }

            System.out.println("Text cannot be empty. Try again.");
        }
    }
    private Priority readPriority() {
        while (true) {
            String input = readNonEmptyText();

            try{
                return Priority.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid priority. Choose LOW, MEDIUM or HIGH");
            }
        }
    }
    private void displayTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task);
        }
    }


}
