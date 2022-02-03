package common.discovery.messages;

import java.util.Date;

public class SystemMessage {
    private final String message;
    private final Date date = new Date();

    public SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }
}
