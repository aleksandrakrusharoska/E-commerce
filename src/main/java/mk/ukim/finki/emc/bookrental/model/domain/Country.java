package mk.ukim.finki.emc.bookrental.model.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "countries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String continent;
}
