package it.bootcamp.user.utils.converter;

import it.bootcamp.user.dao.entity.UserEntity;
import it.bootcamp.user.dto.UserRequestDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserRequestDtoToEntityConverter implements Converter<UserRequestDto, UserEntity> {
    public UserEntity convert(UserRequestDto dto) {
        return UserEntity.Builder.builder()
                .setFirstName(dto.getFirstName())
                .setLastName(dto.getLastName())
                .setPatronymic(dto.getPatronymic())
                .setEmail(dto.getEmail())
                .setRole(dto.getRole() != null ? dto.getRole().name() : null)
                .build();
    }
}
