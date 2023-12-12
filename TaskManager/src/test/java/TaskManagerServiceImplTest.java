import jakarta.persistence.ExcludeDefaultListeners;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import task_manager.dto.TaskResponse;
import task_manager.model.Task;
import task_manager.repository.TaskRepository;
import task_manager.utils.TaskManagerServiceImpl;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskManagerServiceImplTest {

    @Mock
    TaskRepository taskRepository;

    @InjectMocks
    private TaskManagerServiceImpl service;
    Task testTask;
    Task expected;

    @BeforeEach
    void setUp(){
        testTask = new Task("Clean the room", "Bathroom", "Low");
        testTask.setId(1L);
        expected = new Task("Clean the room", "Bathroom", "Middle");
        expected.setStatus("Завершен");
        expected.setId(1L);
    }

    @Test
    void testEditTask(){
        when(taskRepository.getReferenceById((long) 1)).thenReturn(testTask);
        TaskResponse response = service.editTask(1, null, null, "Завершен", "Middle");
        Assertions.assertEquals(expected, response.getTask());
    }
}
