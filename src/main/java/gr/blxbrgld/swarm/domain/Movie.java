package gr.blxbrgld.swarm.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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

    @Column(name = "TITLE")
    @Length(min = 3, max = 500)
    @NotNull
    private String title;
}