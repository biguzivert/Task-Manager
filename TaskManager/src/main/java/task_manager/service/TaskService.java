package task_manager.service;

import task_manager.dto.TaskResponse;
import task_manager.repository.TaskRepository;

public interface TaskService {
    TaskResponse createTask(String title, String description, String priority);

    TaskResponse editTask(int id, String title, String description, String status, String priority);

    TaskResponse getTask();

    TaskResponse deleteTask(int taskId);

}
