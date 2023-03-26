package it.bootcamp.user.constant;

public final class ErrorMessageForUser {
    private ErrorMessageForUser() {
    }

    public static final String INCORRECT_PARAMS = "request contains invalid params";

    public static final String SERVER_ERROR = "server error; try repeating the request";

    public static final String INVALID_PAGE = "page index must not be less than zero";

    public static final String FIELD_MISSING = "field missing";

    public static final String MAX_LENGTH = "field max length must not be greater than ";

    public static final String ONLY_LETTERS = "only latin letters are allowed";
}
