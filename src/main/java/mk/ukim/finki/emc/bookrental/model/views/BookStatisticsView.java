package mk.ukim.finki.emc.bookrental.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "book_statistics_mv")
@Getter
@Immutable
public class BookStatisticsView {

    @Id
    private String category;

    @Column(name = "total_books")
    private Long totalBooks;

    @Column(name = "total_available_copies")
    private Integer totalAvailableCopies;

    @Column(name = "books_not_in_good_condition")
    private Long booksNotInGoodCondition;
}