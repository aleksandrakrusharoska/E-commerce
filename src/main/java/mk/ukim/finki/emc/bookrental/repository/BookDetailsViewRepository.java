package mk.ukim.finki.emc.bookrental.repository;

import mk.ukim.finki.emc.bookrental.model.views.BookDetailsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDetailsViewRepository extends JpaRepository<BookDetailsView, Long> {
}