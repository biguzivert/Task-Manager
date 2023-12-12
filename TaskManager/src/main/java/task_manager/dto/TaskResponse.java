package task_manager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import task_manager.model.Task;

@Data
@Schema(description = "Результат выполнения запроса")
public class TaskResponse {

    @Schema(description = "Запрос выполнен/не выполнен")
    private boolean result;

    private Task task;
}
