package gr.blxbrgld.swarm.services;

import gr.blxbrgld.swarm.domain.Movie;
import gr.blxbrgld.swarm.persistence.MovieDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * MovieService Implementation
 * @author blxbrgld
 */
@Slf4j
@Service
@Transactional(readOnly = true)
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Movie> getAll() { //TODO Is This Needed?
        return movieDao.getAll();
    }
}
