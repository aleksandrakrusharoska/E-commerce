package mk.ukim.finki.emc.bookrental.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "popular_authors_view")
@Getter
@Immutable
public class PopularAuthorView {

    @Id
    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "author_full_name")
    private String authorFullName;

    @Column(name = "total_rentals")
    private Long totalRentals;
}