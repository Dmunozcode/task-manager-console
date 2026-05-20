package service;

import model.Task;

import java.util.ArrayList;

public class TaskService {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(int id, String title, String description){
        Task task = new Task(id,title,description);
        tasks.add(task);
    }
    public ArrayList<Task> getTasks(){
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
}
