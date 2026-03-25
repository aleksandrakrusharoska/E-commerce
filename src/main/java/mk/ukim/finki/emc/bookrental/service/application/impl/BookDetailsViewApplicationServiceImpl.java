package mk.ukim.finki.emc.bookrental.service.application.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emc.bookrental.model.dto.DisplayBookDetailsViewDto;
import mk.ukim.finki.emc.bookrental.service.application.BookDetailsViewApplicationService;
import mk.ukim.finki.emc.bookrental.service.domain.BookDetailsViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookDetailsViewApplicationServiceImpl implements BookDetailsViewApplicationService {

    private final BookDetailsViewService bookDetailsViewService;

    @Override
    public List<DisplayBookDetailsViewDto> findAll() {
        return bookDetailsViewService.findAll()
                .stream()
                .map(DisplayBookDetailsViewDto::from)
                .toList();
    }
}