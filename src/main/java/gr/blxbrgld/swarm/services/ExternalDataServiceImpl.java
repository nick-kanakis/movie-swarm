package gr.blxbrgld.swarm.services;

import gr.blxbrgld.swarm.domain.Genre;
import gr.blxbrgld.swarm.domain.Genres;
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

import java.text.MessageFormat;
import java.util.List;
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
    public Optional<Movies> search(String query) { //TODO More &append_to_response=options
        RestTemplate restTemplate = new RestTemplate();
        String url = MessageFormat.format("{0}search/movie?query={1}&api_key={2}", Constants.API_URL, query, apiKey);
        ResponseEntity<Movies> response = restTemplate.getForEntity(url, Movies.class);
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
        String url = MessageFormat.format("{0}movie/{1}?append_to_response=credits&api_key={2}", Constants.API_URL, id, apiKey);
        ResponseEntity<Movie> response = restTemplate.getForEntity(url, Movie.class);
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
    public List<Genre> genres() {
        RestTemplate restTemplate = new RestTemplate();
        String url = MessageFormat.format("{0}genre/movie/list?api_key={1}", Constants.API_URL, apiKey);
        ResponseEntity<Genres> response = restTemplate.getForEntity(url, Genres.class);
        if(response.getStatusCode().equals(HttpStatus.OK)) {
            return response.getBody().getGenres();
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
