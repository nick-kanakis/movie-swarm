package gr.blxbrgld.swarm.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import gr.blxbrgld.swarm.utils.ApplicationUtils;
import gr.blxbrgld.swarm.utils.Constants;

import java.io.IOException;

/**
 * Custom Deserializer To Extract The Year Of A Date Represented As String
 * @author blxbrgld
 */
public class YearDeserializer extends JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
        JsonNode node = parser.getCodec().readTree(parser);
        return ApplicationUtils.yearFromDate(node.asText(), Constants.RELEASE_DATE_FORMAT);
    }
}
