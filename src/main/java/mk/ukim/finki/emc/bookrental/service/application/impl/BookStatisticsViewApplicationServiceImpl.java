package mk.ukim.finki.emc.bookrental.service.application.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emc.bookrental.model.dto.DisplayBookStatisticsDto;
import mk.ukim.finki.emc.bookrental.service.application.BookStatisticsViewApplicationService;
import mk.ukim.finki.emc.bookrental.service.domain.BookStatisticsViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookStatisticsViewApplicationServiceImpl implements BookStatisticsViewApplicationService {

    private final BookStatisticsViewService service;

    @Override
    public List<DisplayBookStatisticsDto> findAll() {
        return service.findAll()
                .stream()
                .map(DisplayBookStatisticsDto::from)
                .toList();
    }
}