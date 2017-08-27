package gr.blxbrgld.swarm.services;

import gr.blxbrgld.swarm.domain.Genre;
import gr.blxbrgld.swarm.persistence.GenreDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * GenreService Implementation
 * @author blxbrgld
 */
@Slf4j
@Service
@Transactional(readOnly = true)
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreDao genreDao;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = false)
    public void persistGenres(List<Genre> genres) {
        for(Genre genre : genres) {
            genreDao.persistOrMerge(genre);
        }
    }
}
