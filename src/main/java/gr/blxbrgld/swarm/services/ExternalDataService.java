package gr.blxbrgld.swarm.services;

import gr.blxbrgld.swarm.domain.Genre;
import gr.blxbrgld.swarm.domain.Movie;
import gr.blxbrgld.swarm.domain.Movies;
import gr.blxbrgld.swarm.enums.ImageSize;

import java.util.List;
import java.util.Optional;

/**
 * ExternalDataService Interface
 * @author blxbrgld
 */
public interface ExternalDataService {

    //TODO Javadoc
    Optional<Movies> search(String query);

    //TODO Javadoc
    Movie details(Long id);

    //TODO Javadoc
    List<Genre> genres();

    //TODO Javadoc
    void getImage(String path, ImageSize size);
}
