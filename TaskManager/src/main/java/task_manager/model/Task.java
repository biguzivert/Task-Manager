package task_manager.model;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "task")
@Data
@Schema(description = "Сущность задачи")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Заголовок задачи")
    private String title;

    @Schema(description = "Описание задачи")
    private String description;

    @Column(nullable = false)
    @Schema(description = "Статус выполнения задачи", example = "В ожидании, В процессе, Завершено")
    private String status;

    @Schema(description = "Приоритет задачи", example = "Низкий, Средний, Высокий")
    private String priority;

    public Task(){}

    public Task(String title, String description, String priority){
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

}
