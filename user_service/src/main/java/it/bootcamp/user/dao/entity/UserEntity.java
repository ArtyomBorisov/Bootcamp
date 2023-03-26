package it.bootcamp.user.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users", schema = "app")
public class UserEntity {
    @Id
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String patronymic;
    private String email;
    private String role;

    private UserEntity() {
    }

    public Long getId() {
        return id;
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

    public String getRole() {
        return role;
    }

    public static class Builder {
        private final UserEntity entity;

        private Builder() {
            entity = new UserEntity();
        }

        public Builder setId(Long id) {
            entity.id = id;
            return this;
        }

        public Builder setFirstName(String firstName) {
            entity.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            entity.lastName = lastName;
            return this;
        }

        public Builder setPatronymic(String patronymic) {
            entity.patronymic = patronymic;
            return this;
        }

        public Builder setEmail(String email) {
            entity.email = email;
            return this;
        }

        public Builder setRole(String role) {
            entity.role = role;
            return this;
        }

        public static Builder builder() {
            return new Builder();
        }

        public UserEntity build() {
            return entity;
        }
    }
}
