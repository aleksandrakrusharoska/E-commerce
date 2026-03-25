package mk.ukim.finki.emc.bookrental.service.domain;

import mk.ukim.finki.emc.bookrental.model.views.BookStatisticsView;

import java.util.List;

public interface BookStatisticsViewService {
    List<BookStatisticsView> findAll();
}