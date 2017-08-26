package gr.blxbrgld.swarm.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * Movie Domain Object
 * @author blxbrgld
 */
@Data
@Entity
@Table(name = "SW_MOVIE")
public class Movie extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Transient //TODO Persist It
    @JsonProperty("imdb_id")
    private String imdbId;

    @Column(name = "TITLE")
    @Length(min = 3, max = 500)
    @NotNull
    private String title;

    @Transient //TODO Persist It
    @JsonProperty("original_title")
    private String originalTitle;

    @Transient //TODO Persist It
    @JsonProperty("overview")
    private String overview;

    @Transient //TODO Persist It
    @JsonProperty("poster_path")
    private String posterPath;
}