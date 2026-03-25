package mk.ukim.finki.emc.bookrental.jobs;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.emc.bookrental.repository.BookStatisticsViewRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MaterializedViewRefreshScheduler {

    //    private final MaterializedViewRefreshService refreshService;
    private final BookStatisticsViewRepository bookStatisticsViewRepository;

    @Scheduled(cron = "0 * * * * *")
    public void refreshBookStatisticsScheduled() {
        log.info("Scheduled refresh started for materialized view");
//        refreshService.refreshBookStatistics();
        bookStatisticsViewRepository.refresh();
        log.info("Scheduled refresh finished for materialized view");
    }
}