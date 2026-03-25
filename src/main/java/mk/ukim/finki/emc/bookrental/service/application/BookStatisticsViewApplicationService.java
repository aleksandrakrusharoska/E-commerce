package mk.ukim.finki.emc.bookrental.service.application;

import mk.ukim.finki.emc.bookrental.model.dto.DisplayBookStatisticsDto;

import java.util.List;

public interface BookStatisticsViewApplicationService {
    List<DisplayBookStatisticsDto> findAll();
}