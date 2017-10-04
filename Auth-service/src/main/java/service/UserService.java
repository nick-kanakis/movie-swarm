package service;

import domain.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by Nick Kanakis on 3/6/2017.
 */
public interface UserService {

    void create(User user);

    void delete(String username);

    UserDetails loadUserByUsername(String username);
}
