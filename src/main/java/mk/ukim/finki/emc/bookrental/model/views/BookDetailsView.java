package mk.ukim.finki.emc.bookrental.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "book_details_view")
@Getter
@Immutable
public class BookDetailsView {
    @Id
    private Long id;

    private String name;

    private String category;

    private String state;

    @Column(name = "available_copies")
    private Integer availableCopies;

    @Column(name = "author_full_name")
    private String authorFullName;

    @Column(name = "country_name")
    private String countryName;
}