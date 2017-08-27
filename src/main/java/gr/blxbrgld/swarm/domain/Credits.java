package gr.blxbrgld.swarm.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gr.blxbrgld.swarm.jackson.CrewDeserializer;
import lombok.Data;

import java.util.List;

/**
 * A Wrapper Of The Credit Domain Object In Order To Automatically Get Credits By Department
 * @author blxbrgld
 */
@Data
public class Credits { //No Need To Extend The Base Entity

    private List<Credit> cast;

    @JsonDeserialize(using = CrewDeserializer.class)
    private List<Credit> crew;
}
