package gr.blxbrgld.swarm.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * A Wrapper Of The Movie Domain Object In Order To Execute /search, /discover and /find Queries
 * @author blxbrgld
 */
@Data
public class Movies { //No Need To Extend The Base Entity

    private Integer page;

    @JsonProperty("total_results")
    private Integer totalResults;

    @JsonProperty("total_pages")
    private Integer totalPages;

    private List<Movie> results;
}
