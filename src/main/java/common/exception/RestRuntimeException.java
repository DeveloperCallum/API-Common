package common.exception;

import org.springframework.http.HttpStatus;

public class RestRuntimeException extends RuntimeException {
    private RestErrorObject error = new RestErrorObject();

    public RestRuntimeException(RestErrorObject error) {
        super(error.getMessage());
        this.error = error;
    }

    public RestRuntimeException(String message, HttpStatus httpStatus) {
        super(message);
        error.setMessage(message);
        error.setStatus(httpStatus);
    }

    public RestRuntimeException(String message, String type, HttpStatus status) {
        super(message);
        error.setMessage(message);
        error.setType(type);
        error.setStatus(status);
    }

    public RestErrorObject getErrorObject() {
        return error;
    }
}
