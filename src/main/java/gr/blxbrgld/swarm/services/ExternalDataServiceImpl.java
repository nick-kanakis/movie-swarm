package gr.blxbrgld.swarm.services;

import gr.blxbrgld.swarm.domain.Movie;
import gr.blxbrgld.swarm.domain.Movies;
import gr.blxbrgld.swarm.enums.ImageSize;
import gr.blxbrgld.swarm.exceptions.MovieDbException;
import gr.blxbrgld.swarm.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * ExternalDataService Implementation Using themoviedb API
 * @author blxbrgld
 */
@Slf4j
@Service
public class ExternalDataServiceImpl implements ExternalDataService {

    @Value("${apiKey}")
    private String apiKey;

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Movies> search(String query) { //TODO &append_to_response=options
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Movies> response = restTemplate.getForEntity(Constants.API_URL + "search/movie?query=" + query + "&api_key=" + apiKey, Movies.class);
        if(response.getStatusCode().equals(HttpStatus.OK)) {
            Movies results = response.getBody();
            return results.getTotalResults()>0 ? Optional.of(results) : Optional.empty();
        } else {
            throw new MovieDbException("The API Returned With Status != HttpStatus.OK."); //TODO Better Handling
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Movie details(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Movie> response = restTemplate.getForEntity(Constants.API_URL + "movie/" + id + "?api_key=" + apiKey, Movie.class);
        if(response.getStatusCode().equals(HttpStatus.OK)) {
            return response.getBody();
        } else {
            throw new MovieDbException("The API Returned With Status != HttpStatus.OK."); //TODO Better Handling
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getImage(String path, ImageSize size) {
        //TODO Implementation Using ApplicationUtils.buildImageUrl()
    }
}
