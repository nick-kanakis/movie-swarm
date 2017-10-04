package configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import repository.UserRepository;
import service.UserServiceImpl;

/**
 * Created by Nick Kanakis on 9/6/2017.
 */

@Configuration
public class GlobalAuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserServiceImpl userService;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
        auth.authenticationProvider(authProvider());
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService);
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authProvider;
    }

    @Bean
    UserDetailsService userDetailsService() {
        return (username) -> userRepository
                .findByUsername(username);
    }
}
