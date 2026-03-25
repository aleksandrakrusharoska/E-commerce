package mk.ukim.finki.emc.bookrental.service.domain.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emc.bookrental.model.views.BookStatisticsView;
import mk.ukim.finki.emc.bookrental.repository.BookStatisticsViewRepository;
import mk.ukim.finki.emc.bookrental.service.domain.BookStatisticsViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookStatisticsViewServiceImpl implements BookStatisticsViewService {

    private final BookStatisticsViewRepository repository;

    @Override
    public List<BookStatisticsView> findAll() {
        return repository.findAll();
    }
}