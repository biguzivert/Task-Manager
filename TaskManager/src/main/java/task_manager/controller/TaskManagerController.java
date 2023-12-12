package task_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task_manager.dto.TaskResponse;
import task_manager.service.TaskService;

@RestController
public class TaskManagerController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/task")
    public ResponseEntity<TaskResponse> createTask(String title, String description, String priority){
        TaskResponse taskResponse = taskService.createTask(title, description, priority);
        if(!taskResponse.isResult()){
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.ok(taskResponse);
    }

    @DeleteMapping("/task/{id:\\d+}")
    public ResponseEntity<TaskResponse> deleteTask(@PathVariable Long id){
        TaskResponse taskResponse = taskService.deleteTask(id);
        if(!taskResponse.isResult()){
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.ok(taskService.deleteTask(id));
    }

    @PutMapping("/task/{id:\\d+}")
    public ResponseEntity<TaskResponse> editTask(@PathVariable Long id, String title, String description, String status, String priority){
        return ResponseEntity.ok(taskService.editTask(id, title, description, status, priority));
    }

    @GetMapping(value = "/task/{id:\\d+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskResponse> getTask(@PathVariable Long id){
        return ResponseEntity.ok(taskService.getTask(id));
    }


}
