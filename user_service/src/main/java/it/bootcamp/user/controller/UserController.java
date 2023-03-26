package it.bootcamp.user.controller;

import it.bootcamp.user.dto.UserRequestDto;
import it.bootcamp.user.dto.UserResponseDto;
import it.bootcamp.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

import static it.bootcamp.user.constant.ErrorMessageForUser.INVALID_PAGE;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody @Valid UserRequestDto dto) {
        userService.save(dto);
    }

    @GetMapping
    public Page<UserResponseDto> get(@RequestParam @Min(value = 0, message = INVALID_PAGE) int page) {
        return userService.get(page);
    }

    @GetMapping("/all")
    public List<UserResponseDto> getAll() {
        return userService.getAll();
    }
}
