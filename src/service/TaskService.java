package service;

import model.Priority;
import model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(int id, String title, String description, Priority priority){
        Task task = new Task(id,title,description, priority);
        tasks.add(task);
    }
    public List<Task> getTasks(){
        return tasks;
    }
    public Task findTaskById(int id){
        for (Task task : tasks){
            if(task.getId() == id){
                return task;
            }
        }
        return null;
    }
    public boolean markTaskAsCompleted(int id){
        Task taskToComplete = findTaskById(id);

        if(taskToComplete == null){
            return false;
        }

        taskToComplete.markAsCompleted();
        return true;
    }
    public boolean deleteTask(int id){
        Task taskToDelete = findTaskById(id);

        if(taskToDelete == null){
            return false;
        }

        tasks.remove(taskToDelete);
        return true;

    }
    public List<Task> filterByPriority(Priority priority){
        return tasks.stream()
                .filter(task -> task.getPriority() == priority)
                .toList();
    }
    public List<Task> filterByStatus(boolean completed){
        return tasks.stream()
                .filter(task -> task.isCompleted() == completed)
                .toList();
    }
}
