package task_manager.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import task_manager.model.User;

import java.util.List;

public interface UserService{

    UserDetails loadUserByEmail(String email);

    User findUserbyId(long id);

    List<User> allUsers();

    boolean saveUser(User user);

    boolean deleteUser(Long userId);

}
