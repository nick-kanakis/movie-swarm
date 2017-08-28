package gr.blxbrgld.swarm.utils;

import java.util.*;

/**
 * Constants Class
 * @author blxbrgld
 */
public class Constants {

    // Static Map Of The Allowed Jobs (Key = Department, Value = List Of Related Jobs)
    // A Complete Can Be Found Via https://api.themoviedb.org/3/job/list?api_key=api_key
    public static final Map<String, List<String>> allowedJobs;
    static {
        Map<String, List<String>> jobs = new HashMap<>();
        jobs.put("Directing", Arrays.asList(new String[] { "Director" }));
        allowedJobs = Collections.unmodifiableMap(jobs);
    }

    // View Names
    public static final String HOME_PAGE = "home";

    // Miscellaneous
    public static final String API_URL = "https://api.themoviedb.org/3/";
    public static final String API_IMAGES_URL = "https://image.tmdb.org/t/p/";
    public static final String RELEASE_DATE_FORMAT = "yyyy-dd-mm";
}
