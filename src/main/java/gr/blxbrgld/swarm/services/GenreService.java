package gr.blxbrgld.swarm.services;

import gr.blxbrgld.swarm.domain.Genre;

import java.util.List;

/**
 * GenreService Interface
 * @author blxbrgld
 */
public interface GenreService {

    //TODO Javadoc
    void persistGenres(List<Genre> genres);
}
