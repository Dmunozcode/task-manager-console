import java.util.ArrayList;
import java.util.Scanner;

public class TaskApp {
    public static void main(String[] args) {
        int option = 0;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();
        do{
            showMenu();
            option = scanner.nextInt();
            switch (option){
                case 1:
                    addTask(scanner, tasks);
                    break;
                case 2:
                    listTasks(tasks);
                    break;
                case 3:
                    markTaskAsCompleted(scanner, tasks);
                    break;
                case 4:
                    deleteTask(scanner, tasks);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid option...");
            }


        }while(option != 5);

        System.out.println("Exiting app...");
        scanner.close();

    }
    public static void showMenu(){
        System.out.println("1. Add task: ");
        System.out.println("2. List tasks: ");
        System.out.println("3. Mark task as completed: ");
        System.out.println("4. Delete task: ");
        System.out.println("5. Exit: ");

    }
    public static void addTask(Scanner scanner, ArrayList<Task> tasks){
        System.out.println("Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Title: ");
        String title = scanner.nextLine();
        System.out.println("Description: ");
        String description = scanner.nextLine();
        Task task = new Task(id,title,description);
        tasks.add(task);
        System.out.println("Task added successfully");
    }
    public static void listTasks(ArrayList<Task> tasks){
        if (tasks.isEmpty()){
            System.out.println("Empty list");
        }else{
            for(Task task : tasks){
                System.out.println(task);
            }
        }
    }
    public static void markTaskAsCompleted(Scanner scanner, ArrayList<Task> tasks){
        System.out.println("Id: ");
        int id = scanner.nextInt();
        Task taskToComplete = null;
        for (Task task : tasks){
            if(task.getId() == id){
                taskToComplete = task;
            }
        }
        if(taskToComplete == null){
            System.out.println("Task not found");
        }else{
            taskToComplete.markAsCompleted();
            System.out.println("Task marked as completed");
        }
    }
    public static void deleteTask(Scanner scanner, ArrayList<Task> tasks){
        System.out.println("Id: ");
        int id = scanner.nextInt();
        Task taskToDelete = null;
        for(Task task : tasks){
            if(task.getId() == id){
                taskToDelete = task;
            }
        }
        if(taskToDelete == null){
            System.out.println("Task not found");
        }else{
            tasks.remove(taskToDelete);
            System.out.println("Task deleted successfully");
        }

    }
}
