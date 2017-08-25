package gr.blxbrgld.swarm.controllers;

import gr.blxbrgld.swarm.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Swarm Controller Class
 * @author blxbrgld
 */
@Controller
public class SwarmController {

    @RequestMapping("/")
    public String home() { //TODO Delete This
        return Constants.HOME_PAGE;
    }
}
