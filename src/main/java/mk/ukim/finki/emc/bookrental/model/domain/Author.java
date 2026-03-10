package mk.ukim.finki.emc.bookrental.model.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author extends BaseAuditableEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id")
    private Country country;
}
