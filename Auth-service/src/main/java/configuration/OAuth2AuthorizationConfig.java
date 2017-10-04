package configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import service.UserServiceImpl;

/**
 * Created by Nick Kanakis on 4/6/2017.
 */

/*
* Authorization server is the one responsible for verifying credentials and if credentials are OK,
* providing the tokens[refresh-token as well as access-token]. It also contains information about registered
* clients and possible access scopes and grant types.
*
* */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    @Value("${password.movieswarm}")
    private String MOVIE_SWARM_PASSWORD;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserServiceImpl userService;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(new InMemoryTokenStore())
                .authenticationManager(authenticationManager) //Enable password grant type.
                .userDetailsService(userService);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.inMemory()
                .withClient("browser")
                .authorizedGrantTypes("refresh_token", "password")
                .secret("12345")
                .scopes("ui")
                .and()
                .withClient("movie-swarm-service")
                .secret(MOVIE_SWARM_PASSWORD)
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("server");

    }

    /*Defines the security constraints on the token endpoint*/
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

}
