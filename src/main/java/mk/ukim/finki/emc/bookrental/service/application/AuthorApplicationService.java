package mk.ukim.finki.emc.bookrental.service.application;

import mk.ukim.finki.emc.bookrental.model.dto.AuthorDto;
import mk.ukim.finki.emc.bookrental.model.dto.CreateAuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorApplicationService {
    List<AuthorDto> findAll();
    Optional<AuthorDto> findById(Long id);
    AuthorDto create(CreateAuthorDto dto);
    Optional<AuthorDto> update(Long id, CreateAuthorDto dto);
    Optional<AuthorDto> deleteById(Long id);
}