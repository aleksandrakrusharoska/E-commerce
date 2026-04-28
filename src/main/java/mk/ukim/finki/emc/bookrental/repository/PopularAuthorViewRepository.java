package mk.ukim.finki.emc.bookrental.repository;

import mk.ukim.finki.emc.bookrental.model.views.PopularAuthorView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PopularAuthorViewRepository extends JpaRepository<PopularAuthorView, Long> {
    List<PopularAuthorView> findAllByOrderByTotalRentalsDesc();
}
