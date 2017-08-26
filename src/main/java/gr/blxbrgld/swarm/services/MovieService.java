package gr.blxbrgld.swarm.services;

import gr.blxbrgld.swarm.domain.Movie;

import java.util.List;
import java.util.Optional;

/**
 * MovieService Interface
 * @author blxbrgld
 */
public interface MovieService {

    //TODO Javadoc
    List<Movie> getAll();

    //TODO Javadoc
    Optional<List<Movie>> search(String query);
}
