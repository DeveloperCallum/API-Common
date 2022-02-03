package common.discovery;

import common.discovery.messages.ServiceFoundResponse;
import org.springframework.web.client.RestTemplate;

public class DiscoveryUtils {
    public static String getServiceHostname(String serviceName, String discovery){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://" + discovery + "/services/" + serviceName, ServiceFoundResponse.class).getHostname();
    }

    public static ServiceFoundResponse getServiceData(String serviceName, String discovery){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://" + discovery + "/services/" + serviceName, ServiceFoundResponse.class);
    }
}
