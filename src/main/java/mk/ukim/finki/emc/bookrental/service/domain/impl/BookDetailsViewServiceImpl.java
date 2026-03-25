package mk.ukim.finki.emc.bookrental.service.domain.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emc.bookrental.model.views.BookDetailsView;
import mk.ukim.finki.emc.bookrental.repository.BookDetailsViewRepository;
import mk.ukim.finki.emc.bookrental.service.domain.BookDetailsViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookDetailsViewServiceImpl implements BookDetailsViewService {

    private final BookDetailsViewRepository repository;

    @Override
    public List<BookDetailsView> findAll() {
        return repository.findAll();
    }
}