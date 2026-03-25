package mk.ukim.finki.emc.bookrental.events;

import mk.ukim.finki.emc.bookrental.model.domain.Book;

public record BookRentedEvent(Book book) {
}
