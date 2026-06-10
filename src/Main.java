import repository.TaskRepository;
import service.TaskService;
import ui.Menu;

public class Main {
    public static void main(String[] args) {
        TaskRepository taskRepository = new TaskRepository();
        TaskService taskService = new TaskService(taskRepository);
        Menu menu = new Menu(taskService);

        menu.start();
    }
}
