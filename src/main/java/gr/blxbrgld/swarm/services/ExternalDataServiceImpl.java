package gr.blxbrgld.swarm.services;

import gr.blxbrgld.swarm.domain.Movie;
import gr.blxbrgld.swarm.enums.ImageSize;
import gr.blxbrgld.swarm.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
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
    public Optional<List<Movie>> search(String query) { //TODO Implementation
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Movie> response = restTemplate.getForEntity(Constants.API_URL + "/3/movie/550?api_key=" + apiKey, Movie.class);
        if(response.getStatusCode().equals(HttpStatus.OK)) {
            Movie result = response.getBody();
            return Optional.of(Arrays.asList(new Movie[]{result}));
        } else {
            log.error("RestTemplate Request Return Status Code {}.", response.getStatusCodeValue());
            return Optional.empty();
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
