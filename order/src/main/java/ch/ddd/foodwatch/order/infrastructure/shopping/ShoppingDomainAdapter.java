package ch.ddd.foodwatch.order.infrastructure.shopping;


import java.util.List;

import org.springframework.stereotype.Component;

import ch.ddd.foodwatch.recipe.api.dto.IngredientDto;


@Component
public class ShoppingDomainAdapter {

    public String createShoppingList(List<IngredientDto> ingredients) {
        // TODO call shopping service
        return "some-shopping-list-id";
    }
}
