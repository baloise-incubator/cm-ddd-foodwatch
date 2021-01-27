package ch.ddd.foodwatch.food.infrastructure.edamame;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class EdamameProperties {

    @Value( "${edamame.app}" )
    private String appId;

    @Value( "${edamame.appKey}" )
    private String appKey;
}
