package gr.blxbrgld.swarm.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * Custom Deserializer To Extract The Year Of A Date Represented As String
 * @author blxbrgld
 */
public class YearDeserializer extends JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
        if(parser.getCurrentToken().equals(JsonToken.VALUE_STRING)) {
            return ApplicationUtils.yearFromDate(parser.getText(), Constants.RELEASE_DATE_FORMAT);
        } else {
            return null;
        }
    }
}
