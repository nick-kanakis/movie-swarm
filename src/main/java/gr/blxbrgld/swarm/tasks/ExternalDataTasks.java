package gr.blxbrgld.swarm.tasks;

import gr.blxbrgld.swarm.aop.LogMethodExecutionTime;
import gr.blxbrgld.swarm.aop.LogMethodInvocation;
import gr.blxbrgld.swarm.domain.Genre;
import gr.blxbrgld.swarm.services.ExternalDataService;
import gr.blxbrgld.swarm.services.GenreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Tasks To Fetch MovieDB API Data
 * @author blxbrgld
 */
@Slf4j
@Component
public class ExternalDataTasks {

    @Autowired
    private ExternalDataService externalDataService;

    @Autowired
    private GenreService genreService;

    @LogMethodInvocation
    @LogMethodExecutionTime
    @Scheduled(cron = "0 15 10 15 * ?") //TODO Change The cron
    public void genres() {
        List<Genre> genres = externalDataService.genres();
        log.info("There Are {} Genres. Trying To Persist Them.", genres.size());
        genreService.persistGenres(genres);
    }
}
