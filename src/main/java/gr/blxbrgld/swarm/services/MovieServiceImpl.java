package gr.blxbrgld.swarm.services;

import gr.blxbrgld.swarm.domain.Movie;
import gr.blxbrgld.swarm.persistence.MovieDao;
import gr.blxbrgld.swarm.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * MovieService Implementation
 * @author blxbrgld
 */
@Slf4j
@Service
@Transactional(readOnly = true)
public class MovieServiceImpl implements MovieService {

    @Value("${apiKey}")
    private String apiKey;

    @Autowired
    private MovieDao movieDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Movie> getAll() { //TODO Is This Needed?
        return movieDao.getAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<List<Movie>> search(String query) { //TODO Implementation
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Movie> response = restTemplate.getForEntity(Constants.API_URL + "/3/movie/550?api_key=" + apiKey, Movie.class);
        if(response.getStatusCode().equals(HttpStatus.OK)) {
            Movie result = response.getBody();
            return Optional.of(Arrays.asList(new Movie[] { result }));
        } else {
            log.error("RestTemplate Request Return Status Code {}.", response.getStatusCodeValue());
            return Optional.empty();
        }
    }
}
