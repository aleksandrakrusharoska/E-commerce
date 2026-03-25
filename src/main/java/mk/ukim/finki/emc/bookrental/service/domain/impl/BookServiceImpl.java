package mk.ukim.finki.emc.bookrental.service.domain.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emc.bookrental.events.BookRentedEvent;
import mk.ukim.finki.emc.bookrental.model.domain.Book;
import mk.ukim.finki.emc.bookrental.model.domain.enums.Category;
import mk.ukim.finki.emc.bookrental.model.domain.enums.State;
import mk.ukim.finki.emc.bookrental.model.projection.BookExpandedProjection;
import mk.ukim.finki.emc.bookrental.model.projection.BookShortProjection;
import mk.ukim.finki.emc.bookrental.repository.BookRepository;
import mk.ukim.finki.emc.bookrental.service.domain.BookService;
import mk.ukim.finki.emc.bookrental.service.specification.FieldFilterSpecification;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> update(Long id, Book book) {
        return this.findById(id)
                .map(existingBook -> {
                    existingBook.setName(book.getName());
                    existingBook.setCategory(book.getCategory());
                    existingBook.setAuthor(book.getAuthor());
                    existingBook.setState(book.getState());
                    existingBook.setAvailableCopies(book.getAvailableCopies());
                    return bookRepository.save(existingBook);
                });
    }

    @Override
    public Optional<Book> deleteById(Long id) {
        return this.findById(id)
                .map(book -> {
                    bookRepository.delete(book);
                    return book;
                });
    }

    @Override
    public Book markAsRented(Book book) {
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        Book savedBook = bookRepository.save(book);

        eventPublisher.publishEvent(new BookRentedEvent(savedBook));

        return savedBook;
    }

    @Override
    public List<Book> findAllByIdIsBetween(Long a, Long b) {
        return bookRepository.findAllByIdIsBetween(a, b);
    }

    @Override
    public Optional<Book> findWithAuthorAndCountryById(Long id) {
        return bookRepository.findWithAuthorAndCountryById(id);
    }

    @Override
    public Page<Book> search(
            int page,
            int size,
            String sortBy,
            String direction,
            Category category,
            State state,
            Long authorId,
            Boolean hasAvailableCopies
    ) {
        Pageable pageable = createPageable(page, size, sortBy, direction);

        Specification<Book> spec = Specification
                .where(FieldFilterSpecification.filterEqualsV(Book.class, "category", category))
                .and(FieldFilterSpecification.filterEqualsV(Book.class, "state", state))
                .and(FieldFilterSpecification.filterEquals(Book.class, "author.id", authorId));

        if (hasAvailableCopies != null) {
            spec = hasAvailableCopies
                    ? spec.and(FieldFilterSpecification.greaterThan(Book.class, "availableCopies", 0))
                    : spec.and(FieldFilterSpecification.lessThanOrEqual(Book.class, "availableCopies", 0));
        }

        return bookRepository.findAll(spec, pageable);
    }

    @Override
    public Page<BookShortProjection> findAllShort(int page, int size, String sortBy, String direction) {
        Pageable pageable = createPageable(page, size, sortBy, direction);
        return bookRepository.findAllShortBy(pageable);
    }

    @Override
    public Page<BookExpandedProjection> findAllExpanded(int page, int size, String sortBy, String direction) {
        Pageable pageable = createPageable(page, size, sortBy, direction);
        return bookRepository.findAllExpandedBy(pageable);
    }

    private Pageable createPageable(int page, int size, String sortBy, String direction) {
        if (!"name".equals(sortBy) && !"createdDate".equals(sortBy)) {
            sortBy = "name";
        }

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        return PageRequest.of(page, size, sort);
    }
}