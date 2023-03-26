package it.bootcamp.user.utils.converter;

import it.bootcamp.user.constant.UserRole;
import it.bootcamp.user.dao.entity.UserEntity;
import it.bootcamp.user.dto.UserResponseDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToResponseDtoConverter implements Converter<UserEntity, UserResponseDto> {
    public UserResponseDto convert(UserEntity entity) {
        String name = String.format("%s %s %s", entity.getLastName(), entity.getFirstName(), entity.getPatronymic());
        UserRole role = UserRole.valueOf(entity.getRole());

        return UserResponseDto.Builder.builder()
                .setName(name)
                .setEmail(entity.getEmail())
                .setRole(role)
                .build();
    }
}
