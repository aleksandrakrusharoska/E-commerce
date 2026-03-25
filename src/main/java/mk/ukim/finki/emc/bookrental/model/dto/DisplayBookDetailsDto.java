package mk.ukim.finki.emc.bookrental.model.dto;

import mk.ukim.finki.emc.bookrental.model.domain.Book;
import mk.ukim.finki.emc.bookrental.model.domain.enums.Category;
import mk.ukim.finki.emc.bookrental.model.domain.enums.State;

public record DisplayBookDetailsDto(
        Long id,
        String name,
        Category category,
        String authorFullName,
        String countryName,
        State state,
        Integer availableCopies
) {
    public static DisplayBookDetailsDto from(Book book) {
        return new DisplayBookDetailsDto(
                book.getId(),
                book.getName(),
                book.getCategory(),
                book.getAuthor().getName() + " " + book.getAuthor().getSurname(),
                book.getAuthor().getCountry().getName(),
                book.getState(),
                book.getAvailableCopies()
        );
    }
}