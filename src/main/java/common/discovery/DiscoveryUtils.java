package common.discovery;

import common.discovery.messages.DiscoveryResponse;
import org.springframework.web.client.RestTemplate;

public class DiscoveryUtils {
    public static String getServiceHostname(String serviceName, String discovery){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://" + discovery + "/services/" + serviceName, DiscoveryResponse.class).getHostname();
    }

    public static DiscoveryResponse getServiceData(String serviceName, String discovery){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://" + discovery + "/services/" + serviceName, DiscoveryResponse.class);
    }
}
