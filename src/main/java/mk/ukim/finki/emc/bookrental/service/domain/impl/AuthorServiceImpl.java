package mk.ukim.finki.emc.bookrental.service.domain.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emc.bookrental.model.domain.Author;
import mk.ukim.finki.emc.bookrental.repository.AuthorRepository;
import mk.ukim.finki.emc.bookrental.service.domain.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Optional<Author> update(Long id, Author author) {
        return this.findById(id)
                .map(existingAuthor -> {
                    existingAuthor.setName(author.getName());
                    existingAuthor.setSurname(author.getSurname());
                    existingAuthor.setCountry(author.getCountry());
                    return authorRepository.save(existingAuthor);
                });
    }

    @Override
    public Optional<Author> deleteById(Long id) {
        return this.findById(id)
                .map(author -> {
                    authorRepository.delete(author);
                    return author;
                });
    }
}
