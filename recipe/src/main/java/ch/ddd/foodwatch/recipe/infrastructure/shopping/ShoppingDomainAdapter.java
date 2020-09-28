package ch.ddd.foodwatch.recipe.infrastructure.shopping;

import ch.ddd.foodwatch.recipe.domain.Ingredient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingDomainAdapter {

    public String createShoppingList(List<Ingredient> ingredients) {
        return "some-shopping-list-id";
    }
}
