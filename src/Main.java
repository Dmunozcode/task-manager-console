import service.TaskService;
import ui.Menu;

public class Main {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        Menu menu = new Menu(taskService);

        menu.start();
    }
}
