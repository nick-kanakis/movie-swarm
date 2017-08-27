package gr.blxbrgld.swarm.utils;

import java.util.*;

/**
 * Constants Class
 * @author blxbrgld
 */
public class Constants {

    // Static List Of The Allowed Crew Departments
    public static final List<String> allowedDepartments;
    static {
        List<String> departments = new ArrayList<>();
        departments.add("Directing"); //TODO Add More Departments
        allowedDepartments = Collections.unmodifiableList(departments);
    }

    // Static List Of The Allowed Crew Jobs
    public static final List<String> allowedJobs;
    static {
        List<String> jobs = new ArrayList<>();
        jobs.add("Director"); //TODO Add More Jobs
        allowedJobs = Collections.unmodifiableList(jobs);
    }

    // View Names
    public static final String HOME_PAGE = "home";

    // Miscellaneous
    public static final String API_URL = "https://api.themoviedb.org/3/";
    public static final String API_IMAGES_URL = "https://image.tmdb.org/t/p/";
    public static final String RELEASE_DATE_FORMAT = "yyyy-dd-mm";
}
