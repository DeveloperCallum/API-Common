package common.discovery.messages;

import java.util.List;

public class DiscoveryResponse {
    private RegisterRequest registerRequest;

    public DiscoveryResponse() {
    }

    public DiscoveryResponse(RegisterRequest registerRequest) {
        this.registerRequest = registerRequest;
    }

    public RegisterRequest getRegisterRequest() {
        return registerRequest;
    }

    public boolean endpointExists(String url) {
        return registerRequest.endpointExists(url);
    }

    public String getHostname() {
        return registerRequest.getHostname();
    }

    public String getEndpointRole(String url) {
        return registerRequest.getEndpointRole(url);
    }

    public boolean isEndpointHidden(String url) {
        return registerRequest.isEndpointHidden(url);
    }

    public String getService() {
        return registerRequest.getService();
    }

    public List<RegisterRequest.UrlData> getUrlEndpoints() {
        return registerRequest.getUrlEndpoints();
    }

    @Deprecated
    public String getDefaultRole() {
        return registerRequest.getDefaultRole();
    }
}
