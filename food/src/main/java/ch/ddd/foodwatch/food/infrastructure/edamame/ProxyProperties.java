package ch.ddd.foodwatch.food.infrastructure.edamame;

import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class ProxyProperties {
    @Value( "${proxy.enabled}" )
    private boolean enabled;

    @Value( "${proxy.host}" )
    private String host;

    @Value( "${proxy.port}" )
    private int port;
}
