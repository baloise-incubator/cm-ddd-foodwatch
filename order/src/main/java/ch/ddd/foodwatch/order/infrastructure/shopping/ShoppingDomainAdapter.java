package ch.ddd.foodwatch.order.infrastructure.shopping;


import ch.ddd.foodwatch.recipe.api.dto.IngredientDto;
import ch.ddd.foodwatch.shopping.api.dto.ShoppingListDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;


@Component
public class ShoppingDomainAdapter {

    public String createShoppingList(List<IngredientDto> ingredients) {
        ShoppingListDto shoppingListDto = ShoppingListDto.builder().build();
        WebClient client3 = WebClient.create("http://localhost:8083");
        return client3
                .post()
                .uri("/shoppingLists")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(shoppingListDto)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}
