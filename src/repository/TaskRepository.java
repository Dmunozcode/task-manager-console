package repository;

import model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private final List<Task> tasks = new ArrayList<>();

    public void save(Task task) {
        tasks.add(task);
    }
    public List<Task> findAll() {
        return new ArrayList<>(tasks);
    }
    public Task findById(int id) {
        for (Task task : tasks){
            if(task.getId() == id ){
                return task;
            }
        }
        return null;
    }
    public boolean delete(Task task) {
        return tasks.remove(task);
    }
}
