package gr.blxbrgld.swarm.utils;

import gr.blxbrgld.swarm.enums.ImageSize;
import org.junit.Assert;
import org.junit.Test;

/**
 * ApplicationUtils Tests
 * @author blxbrgld
 */
public class ApplicationUtilsTest {

    @Test
    public void buildImageUrlTest() {
        String result = ApplicationUtils.buildImageUrl("/adw6Lq9FiC9zjYEpOqfq03ituwp.jpg", ImageSize.LARGE);
        Assert.assertEquals("https://image.tmdb.org/t/p/w500/adw6Lq9FiC9zjYEpOqfq03ituwp.jpg", result); //Rule Number One, This Is The Fight Club Poster
    }

    @Test
    public void yearFromDateTest() {
        Assert.assertTrue(ApplicationUtils.yearFromDate("1999-10-25", Constants.RELEASE_DATE_FORMAT).equals(1999));
        Assert.assertNull(ApplicationUtils.yearFromDate("error", Constants.RELEASE_DATE_FORMAT));
    }
}
