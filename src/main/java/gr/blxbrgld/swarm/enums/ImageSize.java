package gr.blxbrgld.swarm.enums;

/**
 * TheMovieDB Image Sizes Enumeration
 * @author blxbrgld
 */
public enum ImageSize {

    THUMBNAIL("w92"),
    SMALL("w185"),
    LARGE("w500"),
    ORIGINAL("original"); //More Sizes Exist

    private final String code;

    private ImageSize(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static ImageSize get(final String code) {
        for(final ImageSize size : ImageSize.values()) {
            if(size.getCode().equals(code)) {
                return size;
            }
        }
        return null;
    }
}
