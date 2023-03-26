package it.bootcamp.user.constant;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.stream.Stream;

public enum UserRole {
    ADMINISTRATOR,
    SALE_USER,
    CUSTOMER_USER,
    SECURE_API_USER;

    @JsonCreator
    public static UserRole fromValue(String value) {
        return Stream.of(UserRole.values())
                .filter(enumValue -> enumValue.name().equals(value.toUpperCase()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
