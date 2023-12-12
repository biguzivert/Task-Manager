package task_manager.model;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

    @NotBlank
    @Schema(description = "Заголовок задачи")
    private String title;

    @Schema(description = "Описание задачи")
    private String description;

    @Column(nullable = false)
    @Schema(description = "Статус выполнения задачи", example = "В ожидании, В процессе, Завершено")
    @Pattern(regexp = "[а-яА-я, a-zA-Z]+")
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
