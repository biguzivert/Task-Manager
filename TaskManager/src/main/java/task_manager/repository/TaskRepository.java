package task_manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import task_manager.model.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}
