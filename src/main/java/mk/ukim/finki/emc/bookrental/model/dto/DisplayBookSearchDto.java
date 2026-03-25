package mk.ukim.finki.emc.bookrental.model.dto;

import mk.ukim.finki.emc.bookrental.model.domain.Book;
import mk.ukim.finki.emc.bookrental.model.domain.enums.Category;
import mk.ukim.finki.emc.bookrental.model.domain.enums.State;

import java.util.List;

public record DisplayBookSearchDto(
        Long id,
        String name,
        Category category,
        String authorFullName,
        State state,
        Integer availableCopies
) {
    public static DisplayBookSearchDto from(Book book) {
        return new DisplayBookSearchDto(
                book.getId(),
                book.getName(),
                book.getCategory(),
                book.getAuthor().getName() + " " + book.getAuthor().getSurname(),
                book.getState(),
                book.getAvailableCopies()
        );
    }

    public static List<DisplayBookSearchDto> from(List<Book> books) {
        return books
                .stream()
                .map(DisplayBookSearchDto::from)
                .toList();
    }
}
