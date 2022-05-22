package common.exception;

import org.springframework.http.HttpStatus;

public class RestException extends Exception {
    private RestErrorObject error = new RestErrorObject();

    public RestException(RestErrorObject error) {
        super(error.getMessage());
        this.error = error;
    }

    public RestException(String message, HttpStatus httpStatus) {
        super(message);
        error.setMessage(message);
        error.setStatus(httpStatus);
    }

    public RestException(String message, String type, HttpStatus status) {
        super(message);
        error.setMessage(message);
        error.setType(type);
        error.setStatus(status);
    }

    public RestErrorObject getErrorObject() {
        return error;
    }
}
