package gr.blxbrgld.swarm.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Genre Domain Object
 * @author blxbrgld
 */
@Data
@Entity
@Table(name = "SW_GENRE")
public class Genre extends BaseEntity { //TODO Implement Strikes By Genre

    private static final long serialVersionUID = 1L;

    @Column(name = "NAME")
    @Length(min = 3, max = 500)
    @NotNull
    private String name;
}
