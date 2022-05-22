package common.exception;

public class UrlDoesNotExistException extends RuntimeException {
    public UrlDoesNotExistException() {
    }

    public UrlDoesNotExistException(String message) {
        super(message);
    }

    public UrlDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UrlDoesNotExistException(Throwable cause) {
        super(cause);
    }

    public UrlDoesNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
