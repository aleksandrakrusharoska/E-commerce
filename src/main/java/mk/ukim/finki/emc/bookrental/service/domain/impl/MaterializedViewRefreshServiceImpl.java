//package mk.ukim.finki.emc.bookrental.service.domain.impl;
//
//import jakarta.persistence.EntityManager;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import mk.ukim.finki.emc.bookrental.service.domain.MaterializedViewRefreshService;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class MaterializedViewRefreshServiceImpl implements MaterializedViewRefreshService {
//
//    private final EntityManager entityManager;
//
//    @Override
//    @Transactional
//    public void refreshBookStatistics() {
//        log.info("Started refreshing materialized view: book_statistics_mv");
//        entityManager.createNativeQuery("REFRESH MATERIALIZED VIEW book_statistics_mv")
//                .executeUpdate();
//        log.info("Finished refreshing materialized view: book_statistics_mv");
//    }
//}