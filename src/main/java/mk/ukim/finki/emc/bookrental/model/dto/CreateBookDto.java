package mk.ukim.finki.emc.bookrental.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import mk.ukim.finki.emc.bookrental.model.domain.Author;
import mk.ukim.finki.emc.bookrental.model.domain.Book;
import mk.ukim.finki.emc.bookrental.model.domain.enums.Category;
import mk.ukim.finki.emc.bookrental.model.domain.enums.State;

public record CreateBookDto(
        @NotBlank
        String name,

        @NotNull
        Category category,

        @NotNull
        Long authorId,

        @NotNull
        State state,

        @NotNull
        @Min(0)
        Integer availableCopies
) {

    public Book toBook(Author author) {
        return new Book(name, category, author, state, availableCopies);
    }
}