package task_manager.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task_manager.dto.TaskResponse;
import task_manager.model.Task;
import task_manager.repository.TaskRepository;
import task_manager.service.TaskService;

@Service
public class TaskManagerServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public TaskResponse createTask(String title, String description, String priority) {
        TaskResponse taskResponse = new TaskResponse();
        if(title == null){
            taskResponse.setResult(false);
            taskResponse.setTask(null);
            return taskResponse;
        }
        Task task = new Task(title, description, priority);
        task.setStatus("В процессе");
        taskResponse.setResult(true);
        taskResponse.setTask(task);
        taskRepository.save(task);
        return taskResponse;
    }

    @Override
    public TaskResponse editTask(long id, String title, String description, String status, String priority) {
        TaskResponse taskResponse = new TaskResponse();
        Task task = taskRepository.getReferenceById(id);
        if(id <= 1){
            taskResponse.setResult(false);
            taskResponse.setTask(null);
            return taskResponse;

        }
        if(title != null){
            task.setTitle(title);
        }
        if(description != null){
            task.setDescription(description);
        }
        if(status != null){
            task.setStatus(status);
        }
        if(priority != null){
            task.setPriority(priority);
        }
        taskRepository.save(task);
        taskResponse.setResult(true);
        taskResponse.setTask(task);
        return taskResponse;
    }

    @Override
    public TaskResponse getTask(long taskId) {
        TaskResponse taskResponse = new TaskResponse();
        Task task = taskRepository.getReferenceById(taskId);
        taskResponse.setResult(true);
        taskResponse.setTask(task);
        return taskResponse;
    }

    @Override
    public TaskResponse deleteTask(long taskId) {
        TaskResponse taskResponse = new TaskResponse();
        Task task = taskRepository.getReferenceById(taskId);
        taskResponse.setResult(true);
        taskResponse.setTask(null);
        taskRepository.delete(task);
        return taskResponse;

    }
}
