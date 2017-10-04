package controller;


import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by Nick Kanakis on 3/6/2017.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {
        return principal;
    }

    @PreAuthorize("#oauth2.hasScope('server')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createUser(@Valid @RequestBody User user) {
        userService.create(user);
    }

    @PreAuthorize("#oauth2.hasScope('server')")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteUser(@Valid @RequestBody String username) {
        userService.delete(username);
    }
}
