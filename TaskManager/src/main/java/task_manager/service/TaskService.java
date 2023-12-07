package task_manager.service;

import task_manager.dto.TaskResponse;
import task_manager.repository.TaskRepository;

public interface TaskService {
    TaskResponse createTask();

    TaskResponse editTask();

    TaskResponse getTask();

    TaskResponse deleteTask();

}
