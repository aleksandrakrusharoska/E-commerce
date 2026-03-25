package mk.ukim.finki.emc.bookrental.model.projection;

import mk.ukim.finki.emc.bookrental.model.domain.enums.Category;
import mk.ukim.finki.emc.bookrental.model.domain.enums.State;

public interface BookExpandedProjection {
    Long getId();

    String getName();

    Category getCategory();

    State getState();

    Integer getAvailableCopies();

    AuthorInfo getAuthor();

    interface AuthorInfo {
        String getName();

        String getSurname();

        CountryInfo getCountry();
    }

    interface CountryInfo {
        String getName();
    }
}
