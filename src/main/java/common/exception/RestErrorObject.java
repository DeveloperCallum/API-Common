package common.exception;

import org.springframework.http.HttpStatus;

import java.util.UUID;

public class RestErrorObject {
    private final UUID traceId = UUID.randomUUID();
    private String message;
    private String type;
    private HttpStatus status;

    protected RestErrorObject(){
    }

    public RestErrorObject(String message, String type, HttpStatus status) {
        this.message = message;
        this.type = type;
        this.status = status;
    }

    public UUID getTraceId() {
        return traceId;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public HttpStatus getStatus() {
        return status;
    }

    protected void setMessage(String message) {
        this.message = message;
    }

    protected void setType(String type) {
        this.type = type;
    }

    protected void setStatus(HttpStatus status) {
        this.status = status;
    }
}
