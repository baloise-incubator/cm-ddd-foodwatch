package ch.ddd.foodwatch.order.infrastructure.shopping;

import ch.ddd.foodwatch.recipe.domain.Ingredient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class ShoppingDomainAdapter {

    public String createShoppingList(List<Ingredient> ingredients) {
        //TODO call shopping service
        return "some-shopping-list-id";
    }
}
