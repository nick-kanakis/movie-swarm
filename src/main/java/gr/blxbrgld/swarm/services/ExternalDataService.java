package gr.blxbrgld.swarm.services;

import gr.blxbrgld.swarm.domain.Movie;
import gr.blxbrgld.swarm.enums.ImageSize;

import java.util.List;
import java.util.Optional;

/**
 * ExternalDataService Interface
 * @author blxbrgld
 */
public interface ExternalDataService {

    //TODO Javadoc
    Optional<List<Movie>> search(String query);

    //TODO Javadoc
    void getImage(String path, ImageSize size);
}
