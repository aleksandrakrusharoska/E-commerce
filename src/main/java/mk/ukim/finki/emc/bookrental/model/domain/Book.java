package mk.ukim.finki.emc.bookrental.model.domain;

import jakarta.persistence.*;
import lombok.*;
import mk.ukim.finki.emc.bookrental.model.domain.enums.Category;
import mk.ukim.finki.emc.bookrental.model.domain.enums.State;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book extends BaseAuditableEntity {
    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id")
    private Author author;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private State state;

    @Column(name = "available_copies", nullable = false)
    private Integer availableCopies;
}
