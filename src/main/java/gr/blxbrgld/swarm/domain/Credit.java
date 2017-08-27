package gr.blxbrgld.swarm.domain;

import lombok.Data;

/**
 * Credit Domain Object
 * @author blxbrgld
 */
@Data
public class Credit { //TODO Would These Be Persisted?

    private Long id; //TODO If Yes, This Should Be Inherited By The BaseEntity
    private String name;
    //The Following Attributes Are Only Present For The crew Credits
    private String department;
    private String job;
}
