package it.bootcamp.user.service;

import it.bootcamp.user.dto.UserRequestDto;
import it.bootcamp.user.dto.UserResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    long save(UserRequestDto dto);
    Page<UserResponseDto> get(int page);
    List<UserResponseDto> getAll();
}
