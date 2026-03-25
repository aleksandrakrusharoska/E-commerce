package mk.ukim.finki.emc.bookrental.repository;

import mk.ukim.finki.emc.bookrental.model.views.BookStatisticsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookStatisticsViewRepository extends JpaRepository<BookStatisticsView, String> {
    @Modifying
    @Query(value = "CALL refresh_book_statistics_view()", nativeQuery = true)
    void refresh();
}