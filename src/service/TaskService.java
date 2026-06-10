package service;

import model.Priority;
import model.Task;
import repository.TaskRepository;

import java.util.List;

public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public void addTask(int id, String title, String description, Priority priority){
        Task task = new Task(id,title,description, priority);
        taskRepository.save(task);
    }
    public List<Task> getTasks(){
        return taskRepository.findAll();
    }
    public Task findTaskById(int id){
        return taskRepository.findById(id);
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

        return taskRepository.delete(taskToDelete);

    }
    public List<Task> filterByPriority(Priority priority){
        return taskRepository.findAll()
                .stream()
                .filter(task -> task.getPriority() == priority)
                .toList();
    }
    public List<Task> filterByStatus(boolean completed){
        return taskRepository.findAll()
                .stream()
                .filter(task -> task.isCompleted() == completed)
                .toList();
    }
}
