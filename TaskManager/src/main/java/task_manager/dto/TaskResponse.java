package task_manager.dto;

import lombok.Data;
import task_manager.model.Task;

@Data
public class TaskResponse {
    private boolean result;

    private Task task;
}
