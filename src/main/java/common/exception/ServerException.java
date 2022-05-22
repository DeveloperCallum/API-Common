package common.exception;

import org.springframework.http.HttpStatus;

public class ServerException extends RestException{

    public ServerException(RestErrorObject error) {
        super(error);
    }

    public ServerException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }

    public ServerException(String message, String type, HttpStatus status) {
        super(message, type, status);
    }
}
