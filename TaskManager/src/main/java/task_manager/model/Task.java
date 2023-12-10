package task_manager.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "task")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private String status;

    private String priority;

    public Task(){}

    public Task(String title, String description, String priority){
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

}
