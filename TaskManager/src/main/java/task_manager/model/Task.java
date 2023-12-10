package task_manager.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "task")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private String status;

    private String priority;

    @Column(name = "user_id", insertable = false, updatable = false)
    private int userId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "FK_task_user"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Task(){}

    public Task(String title, String description, String priority){
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

}
