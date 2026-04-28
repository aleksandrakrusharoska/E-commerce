package mk.ukim.finki.emc.bookrental.service.application;

import mk.ukim.finki.emc.bookrental.model.domain.Book;
import mk.ukim.finki.emc.bookrental.model.domain.enums.Category;
import mk.ukim.finki.emc.bookrental.model.domain.enums.State;
import mk.ukim.finki.emc.bookrental.model.dto.CreateBookDto;
import mk.ukim.finki.emc.bookrental.model.dto.DisplayBookDetailsDto;
import mk.ukim.finki.emc.bookrental.model.dto.DisplayBookDto;
import mk.ukim.finki.emc.bookrental.model.dto.DisplayBookSearchDto;
import mk.ukim.finki.emc.bookrental.model.projection.BookExpandedProjection;
import mk.ukim.finki.emc.bookrental.model.projection.BookShortProjection;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BookApplicationService {
    Optional<DisplayBookDetailsDto> findById(Long id);

    List<DisplayBookDto> findAll();

    DisplayBookDto create(CreateBookDto createBookDto);

    Optional<DisplayBookDto> update(Long id, CreateBookDto createBookDto);

    Optional<DisplayBookDto> deleteById(Long id);

    DisplayBookDto markAsRented(Long id);

    List<DisplayBookDto> findAllByIdIsBetween(Long a, Long b);

    Page<DisplayBookSearchDto> search(
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

    List<DisplayBookDto> findTopPopularBooks();
}
