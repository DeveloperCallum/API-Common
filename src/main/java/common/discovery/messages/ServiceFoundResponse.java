package common.discovery.messages;

public class ServiceFoundResponse {
    private String hostname;
    private String service;
    private String defaultRole;

    public ServiceFoundResponse() {
    }

    public ServiceFoundResponse(String hostname, String service, String defaultRole) {
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
}
