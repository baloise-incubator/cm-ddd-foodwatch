package ch.ddd.foodwatch.food.infrastructure.edamame;

import java.util.UUID;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import ch.ddd.foodwatch.food.domain.Food;
import ch.ddd.foodwatch.food.domain.FoodId;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import lombok.AllArgsConstructor;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;

@Service
@AllArgsConstructor
public class ApiAdapter {
    private final EdamameProperties edamameProperties;
    private final String API_PREFIX = "api/food-database/v2/parser";

    public Food getFoodByName(String name) {
//        SslContext sslContext = null;
//        try {
//            sslContext = SslContextBuilder
//                    .forClient()
//                    .trustManager(InsecureTrustManagerFactory.INSTANCE)
//                    .build();
//            HttpClient httpClient = HttpClient.create().secure(t -> t.sslContext(sslContext));
//        } catch (SSLException e) {
//            e.printStackTrace();
//        }
        WebClient client2 = WebClient.create("https://api.edamam.com");
        WebClient.RequestBodySpec uri1 = client2
                .method(HttpMethod.GET)
                .uri(uriBuilder -> uriBuilder.path(API_PREFIX)
                        .queryParam("ingr", name)
                        .queryParam("app_id", edamameProperties.getAppId())
                        .queryParam("app_key", edamameProperties.getAppKey())
                        .build());
        var result = uri1.retrieve()
                .bodyToMono(EdamameFood.class)
                .block();
        if (result == null || result.getParsed().isEmpty()) {
            return null;
        }
        EdamameFoodItem firstElement = result.getParsed().get(0);
        return new Food(new FoodId(UUID.randomUUID()), result.getText(), firstElement.getFood().getCategory(), firstElement.getFood().getImage());
    }
}
