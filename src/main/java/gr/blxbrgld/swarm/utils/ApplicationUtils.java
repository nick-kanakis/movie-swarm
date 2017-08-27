package gr.blxbrgld.swarm.utils;

import gr.blxbrgld.swarm.enums.ImageSize;

/**
 * ApplicationUtils Class
 * @author blxbrgld
 */
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
}
