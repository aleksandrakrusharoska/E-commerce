package mk.ukim.finki.emc.bookrental.repository;

import mk.ukim.finki.emc.bookrental.model.domain.Book;
import mk.ukim.finki.emc.bookrental.model.projection.BookExpandedProjection;
import mk.ukim.finki.emc.bookrental.model.projection.BookShortProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    List<Book> findAllByIdIsBetween(Long a, Long b);

    @EntityGraph(value = "book-author-country-graph", type = EntityGraph.EntityGraphType.FETCH)
    Optional<Book> findWithAuthorAndCountryById(Long id);

    Page<BookShortProjection> findAllShortBy(Pageable pageable);

    Page<BookExpandedProjection> findAllExpandedBy(Pageable pageable);
}
