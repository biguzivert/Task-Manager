package task_manager.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import task_manager.model.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

    @Modifying
    @Query("SELECT Task FROM Task t WHERE t.id = :id")
    Task getTaskById(@Param("id") int id);

}
