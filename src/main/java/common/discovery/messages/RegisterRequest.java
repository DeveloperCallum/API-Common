package common.discovery.messages;

import common.UrlPathMatcher;
import common.exception.UrlDoesNotExistException;

import java.util.*;

public class RegisterRequest {
    private String hostname;
    private String service;
    private String defaultRole;

    private final List<UrlData> urlEndpoints = new ArrayList<>();

    protected RegisterRequest() {
    }

    @Deprecated
    public RegisterRequest(String hostname, String service, String defaultRole) {
        this.hostname = hostname;
        this.service = service;
        this.defaultRole = defaultRole;
    }

    public RegisterRequest(String hostname, String service) {
        this.hostname = hostname;
        this.service = service;
    }

    public void add(String url, boolean isHidden) {
        UrlData data = new UrlData(UrlPathMatcher.convertURL(url), isHidden);
        this.urlEndpoints.add(data);
    }

    public void add(String url, String role, boolean isHidden) {
        UrlData data = new UrlData(UrlPathMatcher.convertURL(url), role, isHidden);
        this.urlEndpoints.add(data);
    }

    public boolean endpointExists(String url){
        return getEndpoint(url).isPresent();
    }

    private Optional<UrlData> getEndpoint(String url){
        for (UrlData urlData : urlEndpoints){
            if (UrlPathMatcher.matchUrl(urlData.url, url)){
                return Optional.of(urlData);
            }
        }

        return Optional.empty();
    }

    public String getHostname() {
        return hostname;
    }

    /**
     * Throw endpoint does not exist exception!
     */
    public String getEndpointRole(String url){
        Optional<UrlData> data = getEndpoint(url);
        data.orElseThrow(() -> new UrlDoesNotExistException("URL does not exist."));

        return data.get().role;
    }

    /**
     * Throw endpoint does not exist exception!
     */
    public boolean isEndpointHidden(String url){
        Optional<UrlData> data = getEndpoint(url);
        data.orElseThrow(() -> new UrlDoesNotExistException("URL does not exist."));

        return data.get().isHidden;
    }

    public String getService() {
        return service;
    }

    public List<UrlData> getUrlEndpoints() {
        return new ArrayList<>(urlEndpoints);
    }

    @Deprecated
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
                ", urlEndpoints=" + urlEndpoints +
                '}';
    }

    protected static class UrlData {
        private String url;
        private String role;
        private boolean isHidden;

        protected UrlData() {
        }

        public UrlData(String url, boolean isHidden) {
            this.url = url;
            this.isHidden = isHidden;
        }

        public UrlData(String url, String role, boolean isHidden) {
            this.url = url;
            this.role = role;
            this.isHidden = isHidden;
        }

        public String getUrl() {
            return url;
        }

        public String getRole() {
            return role;
        }

        public boolean getIsHidden() {
            return isHidden;
        }

        @Override
        public String toString() {
            return "UrlData{" +
                    "url='" + url + '\'' +
                    ", isHidden=" + isHidden +
                    ", role='" + role + '\'' +
                    '}';
        }
    }
}
