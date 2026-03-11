package mk.ukim.finki.emc.bookrental.service.application.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emc.bookrental.model.domain.Author;
import mk.ukim.finki.emc.bookrental.model.domain.Book;
import mk.ukim.finki.emc.bookrental.model.dto.CreateBookDto;
import mk.ukim.finki.emc.bookrental.model.dto.DisplayBookDto;
import mk.ukim.finki.emc.bookrental.model.exception.NoAvailableCopiesException;
import mk.ukim.finki.emc.bookrental.model.exception.ResourceNotFoundException;
import mk.ukim.finki.emc.bookrental.service.application.BookApplicationService;
import mk.ukim.finki.emc.bookrental.service.domain.AuthorService;
import mk.ukim.finki.emc.bookrental.service.domain.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookApplicationServiceImpl implements BookApplicationService {

    private final BookService bookService;
    private final AuthorService authorService;

    @Override
    public Optional<DisplayBookDto> findById(Long id) {
        return bookService.findById(id)
                .map(DisplayBookDto::from);
    }

    @Override
    public List<DisplayBookDto> findAll() {
        return DisplayBookDto.from(bookService.findAll());
    }

    @Override
    public DisplayBookDto create(CreateBookDto createBookDto) {
        Author author = findAuthorById(createBookDto.authorId());
        return DisplayBookDto.from(bookService.create(createBookDto.toBook(author)));
    }

    @Override
    public Optional<DisplayBookDto> update(Long id, CreateBookDto createBookDto) {
        Author author = findAuthorById(createBookDto.authorId());
        return bookService.update(id, createBookDto.toBook(author))
                .map(DisplayBookDto::from);
    }

    @Override
    public Optional<DisplayBookDto> deleteById(Long id) {
        return bookService.deleteById(id)
                .map(DisplayBookDto::from);
    }

    @Override
    public DisplayBookDto markAsRented(Long id) {
        Book book = bookService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", id));

        if (book.getAvailableCopies() <= 0) {
            throw new NoAvailableCopiesException(id);
        }

        return DisplayBookDto.from(bookService.markAsRented(book));
    }

    @Override
    public List<DisplayBookDto> findAllByIdIsBetween(Long a, Long b) {
        return DisplayBookDto.from(bookService.findAllByIdIsBetween(a, b));
    }

    private Author findAuthorById(Long authorId) {
        return authorService.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author", authorId));
    }
}