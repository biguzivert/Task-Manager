package task_manager.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task_manager.dto.TaskResponse;
import task_manager.service.TaskService;

@RestController
@Tag(name = "Контроллер менеджера задач", description = "Позволяет управлять задачами пользователя")
public class TaskManagerController {

    @Autowired
    private TaskService taskService;

    @Operation(
            summary = "Создание задачи"
    )
    @PostMapping("/task")
    public ResponseEntity<TaskResponse> createTask(@Parameter(description = "Заголовок задачи", required = true) String title,
                                                   @Parameter(description = "Описание задачи") String description,
                                                   @Parameter(description = "Уровень приоритетности задачи") String priority){
        TaskResponse taskResponse = taskService.createTask(title, description, priority);
        if(!taskResponse.isResult()){
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.ok(taskResponse);
    }

    @Operation(
            summary = "Удаление задачи"
    )
    @DeleteMapping("/task/{id:\\d+}")
    public ResponseEntity<TaskResponse> deleteTask(@PathVariable @Parameter(description = "ID задачи", required = true) Long id){
        TaskResponse taskResponse = taskService.deleteTask(id);
        if(!taskResponse.isResult()){
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.ok(taskService.deleteTask(id));
    }

    @Operation(
            summary = "Изменение существующей задачи"
    )
    @PutMapping("/task/{id:\\d+}")
    public ResponseEntity<TaskResponse> editTask(@PathVariable @Parameter(description = "ID задачи") Long id,
                                                 @Parameter(description = "Заголовок задачи") String title,
                                                 @Parameter(description = "Описание задачи") String description,
                                                 @Parameter(description = "Статус задачи") String status,
                                                 @Parameter(description = "Уровень приоритетности задачи") String priority){
        return ResponseEntity.ok(taskService.editTask(id, title, description, status, priority));
    }

    @Operation(
            summary = "Получение задачи"
    )
    @GetMapping(value = "/task/{id:\\d+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskResponse> getTask(@PathVariable @Parameter(description = "ID задачи") Long id){
        return ResponseEntity.ok(taskService.getTask(id));
    }


}
