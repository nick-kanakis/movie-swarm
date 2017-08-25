package gr.blxbrgld.swarm.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main Application's Configuration Class
 */
@SpringBootApplication
@ComponentScan("gr.blxbrgld.swarm")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
