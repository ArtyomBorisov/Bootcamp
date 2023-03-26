package it.bootcamp.user.dto;

import it.bootcamp.user.constant.UserRole;

public class UserResponseDto {
    private String name;
    private String email;
    private UserRole role;

    private UserResponseDto() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public UserRole getRole() {
        return role;
    }

    public static class Builder {
        private final UserResponseDto dto;

        private Builder() {
            dto = new UserResponseDto();
        }

        public Builder setName(String name) {
            dto.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            dto.email = email;
            return this;
        }

        public Builder setRole(UserRole role) {
            dto.role = role;
            return this;
        }

        public static Builder builder() {
            return new Builder();
        }

        public UserResponseDto build() {
            return dto;
        }
    }
}
