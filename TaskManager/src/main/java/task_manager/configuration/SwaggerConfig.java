package task_manager.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Task Manager",
                description = "Система управления задачами",
                contact = @Contact(
                        name = "Гаибов Джафар",
                        email = "xdjafarx@gmail.com",
                        url = "https://github.com/biguzivert"
                )
        )
)
public class SwaggerConfig {

}
