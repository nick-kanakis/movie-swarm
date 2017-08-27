package gr.blxbrgld.swarm.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

/**
 * BaseEntity Domain Object
 * @author blxbrgld
 */
@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATE_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dateUpdated;
}
