package gr.blxbrgld.swarm.utils;

import gr.blxbrgld.swarm.enums.ImageSize;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * ApplicationUtils Class
 * @author blxbrgld
 */
@Slf4j
public class ApplicationUtils {

    /**
     * Build Image's URL Based On The Given Path And Desired Size
     * @param path Image's Path
     * @param size Image's Size
     * @return The Resulting Image's URL
     */
    public static String buildImageUrl(String path, ImageSize size) {
        return new StringBuilder()
            .append(Constants.API_IMAGES_URL)
            .append(size.getCode())
            .append(path)
            .toString();
    }

    /**
     * Extract Year From A Date Represented As String Given The Date And It's Format
     * @param date The Date To Parse
     * @param format The Date's Format
     * @return The Date's Year
     */
    public static Integer yearFromDate(String date, String format) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateFormat.parse(date));
            return calendar.get(Calendar.YEAR);
        } catch(ParseException exception) {
            log.error("Cannot Parse Date [Date = {}, Expected Format = {}].", new Object[] { date, format });
            return null;
        }
    }
}
