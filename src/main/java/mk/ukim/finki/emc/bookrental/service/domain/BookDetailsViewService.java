package mk.ukim.finki.emc.bookrental.service.domain;

import mk.ukim.finki.emc.bookrental.model.views.BookDetailsView;

import java.util.List;

public interface BookDetailsViewService {
    List<BookDetailsView> findAll();
}