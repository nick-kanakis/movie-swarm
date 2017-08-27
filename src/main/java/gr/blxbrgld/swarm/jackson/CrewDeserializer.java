package gr.blxbrgld.swarm.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import gr.blxbrgld.swarm.domain.Credit;
import gr.blxbrgld.swarm.utils.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * We Do Not Want To Persist All crew Credits. This Deserializer Filters The Results According To The allowedDepartments And allowedJobs Lists
 * @author blxbrgld
 */
public class CrewDeserializer extends JsonDeserializer<List<Credit>> {

    @Override
    public List<Credit> deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        final ObjectCodec codec = parser.getCodec();
        final JsonNode nodes = codec.readTree(parser);
        final List<Credit> result = new ArrayList<>();
        if(nodes.isArray()) {
            for(JsonNode node : nodes) {
                Credit credit = codec.treeToValue(node, Credit.class);
                if(Constants.allowedDepartments.contains(credit.getDepartment()) && Constants.allowedJobs.contains(credit.getJob())) {
                    result.add(credit);
                }
            }
        }
        return result;
    }
}
