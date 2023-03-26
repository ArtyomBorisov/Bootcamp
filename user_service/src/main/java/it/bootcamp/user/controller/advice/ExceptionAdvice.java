package it.bootcamp.user.controller.advice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

import static it.bootcamp.user.constant.ErrorMessageForUser.INCORRECT_PARAMS;
import static it.bootcamp.user.constant.ErrorMessageForUser.SERVER_ERROR;

@ControllerAdvice
public class ExceptionAdvice {
    private final Logger logger = LogManager.getLogger();

    @ExceptionHandler({HttpMessageNotReadableException.class, MethodArgumentTypeMismatchException.class})
    public ResponseEntity<?> httpMessageNotReadableHandler(Exception e) {
        log(e);
        return ResponseEntity.badRequest()
                .body(new SingleResponseError(INCORRECT_PARAMS));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidHandler(MethodArgumentNotValidException e) {
        log(e);
        List<Error> errors = e.getBindingResult().getFieldErrors().stream()
                .map(ex -> new Error(ex.getField(), ex.getDefaultMessage()))
                .collect(Collectors.toList());

        return ResponseEntity.badRequest()
                .body(new MultipleResponseError(errors));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> constraintViolationHandler(ConstraintViolationException e) {
        log(e);
        List<Error> errors = e.getConstraintViolations().stream()
                .map(ex -> new Error(ex.getPropertyPath().toString(), ex.getMessage()))
                .collect(Collectors.toList());

        return ResponseEntity.badRequest()
                .body(new MultipleResponseError(errors));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exceptionHandler(Exception e) {
        log(e);
        return ResponseEntity.internalServerError()
                .body(new SingleResponseError(SERVER_ERROR));
    }

    private void log(Exception e) {
        logger.error("{}: {}", e.getClass().getSimpleName(), e.getMessage());
    }
}
