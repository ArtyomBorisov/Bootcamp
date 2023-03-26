package it.bootcamp.user.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import it.bootcamp.user.constant.UserRole;

import javax.validation.constraints.*;

import static it.bootcamp.user.constant.ErrorMessageForUser.*;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRequestDto {
    private static final String REG = "[A-Za-z]+$";

    @NotBlank(message = FIELD_MISSING)
    @Size(max = 20, message = MAX_LENGTH + 20)
    @Pattern(regexp = REG, message = ONLY_LETTERS)
    private String firstName;

    @NotBlank(message = FIELD_MISSING)
    @Size(max = 40, message = MAX_LENGTH + 40)
    @Pattern(regexp = REG, message = ONLY_LETTERS)
    private String lastName;

    @NotBlank(message = FIELD_MISSING)
    @Size(max = 40, message = MAX_LENGTH + 40)
    @Pattern(regexp = REG, message = ONLY_LETTERS)
    private String patronymic;

    @NotBlank(message = FIELD_MISSING)
    @Email
    @Size(max = 50, message = MAX_LENGTH + 50)
    private String email;

    @NotNull(message = FIELD_MISSING)
    private UserRole role;

    private UserRequestDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getEmail() {
        return email;
    }

    public UserRole getRole() {
        return role;
    }

    public static class Builder {
        private final UserRequestDto dto;

        private Builder() {
            dto = new UserRequestDto();
        }

        public Builder setFirstName(String firstName) {
            dto.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            dto.lastName = lastName;
            return this;
        }

        public Builder setPatronymic(String patronymic) {
            dto.patronymic = patronymic;
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

        public UserRequestDto build() {
            return dto;
        }
    }
}
