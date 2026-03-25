package mk.ukim.finki.emc.bookrental.service.domain;

import mk.ukim.finki.emc.bookrental.model.domain.Book;
import mk.ukim.finki.emc.bookrental.model.domain.enums.Category;
import mk.ukim.finki.emc.bookrental.model.domain.enums.State;
import mk.ukim.finki.emc.bookrental.model.projection.BookExpandedProjection;
import mk.ukim.finki.emc.bookrental.model.projection.BookShortProjection;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> findById(Long id);

    List<Book> findAll();

    Book create(Book book);

    Optional<Book> update(Long id, Book book);

    Optional<Book> deleteById(Long id);

    Book markAsRented(Book book);

    List<Book> findAllByIdIsBetween(Long a, Long b);

    Optional<Book> findWithAuthorAndCountryById(Long id);

    Page<Book> search(
            int page,
            int size,
            String sortBy,
            String direction,
            Category category,
            State state,
            Long authorId,
            Boolean hasAvailableCopies
    );

    Page<BookShortProjection> findAllShort(
            int page,
            int size,
            String sortBy,
            String direction
    );

    Page<BookExpandedProjection> findAllExpanded(
            int page,
            int size,
            String sortBy,
            String direction
    );
}
