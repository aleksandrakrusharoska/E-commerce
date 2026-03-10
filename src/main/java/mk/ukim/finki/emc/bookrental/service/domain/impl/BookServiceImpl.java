package mk.ukim.finki.emc.bookrental.service.domain.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emc.bookrental.model.domain.Book;
import mk.ukim.finki.emc.bookrental.repository.BookRepository;
import mk.ukim.finki.emc.bookrental.service.domain.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

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
        return bookRepository.save(book);
    }
}