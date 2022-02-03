package common.discovery.messages;

public class RegisterRequest {
    private String hostname;
    private String service;
    private String defaultRole;

    public RegisterRequest() {
    }

    public RegisterRequest(String hostname, String service, String defaultRole) {
        this.hostname = hostname;
        this.service = service;
        this.defaultRole = defaultRole;
    }

    public String getHostname() {
        return hostname;
    }

    public String getService() {
        return service;
    }

    public String getDefaultRole() {
        return defaultRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterRequest that = (RegisterRequest) o;
        return hostname.equals(that.hostname) && service.equals(that.service);
    }

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "hostname='" + hostname + '\'' +
                ", service='" + service + '\'' +
                ", defaultRole='" + defaultRole + '\'' +
                '}';
    }
}
