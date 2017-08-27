package gr.blxbrgld.swarm.domain;

import lombok.Data;

import java.util.List;

/**
 * A Wrapper Of The Genre Domain Object In Order To Automatically Get Credits By Department
 * @author blxbrgld
 */
@Data
public class Genres {

    private List<Genre> genres;
}
