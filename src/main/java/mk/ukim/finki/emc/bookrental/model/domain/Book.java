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
@NamedEntityGraph(
        name = "book-author-country-graph",
        attributeNodes = {
                @NamedAttributeNode(value = "author", subgraph = "author-country-subgraph")
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "author-country-subgraph",
                        attributeNodes = {
                                @NamedAttributeNode("country")
                        }
                )
        }
)
public class Book extends BaseAuditableEntity {
    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id")
    private Author author;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private State state;

    @Column(name = "available_copies", nullable = false)
    private Integer availableCopies;

    @Column(nullable = false)
    private Integer rentCount = 0;

    public Book(String name, Category category, Author author, State state, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.state = state;
        this.availableCopies = availableCopies;
    }
}
