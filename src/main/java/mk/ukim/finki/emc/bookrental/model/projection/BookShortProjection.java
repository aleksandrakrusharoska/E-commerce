package mk.ukim.finki.emc.bookrental.model.projection;

import mk.ukim.finki.emc.bookrental.model.domain.enums.Category;
import mk.ukim.finki.emc.bookrental.model.domain.enums.State;

public interface BookShortProjection {
    Long getId();

    String getName();

    Category getCategory();

    State getState();

    Integer getAvailableCopies();
}
