package ch.ddd.foodwatch.shopping.infrastructure.persistence;

import org.springframework.stereotype.Component;

import ch.ddd.foodwatch.shopping.domain.ShoppingList;
import ch.ddd.foodwatch.shopping.domain.ShoppingListId;

@Component
public class ShoppingRepository {

    public ShoppingList get(ShoppingListId id) {
        return new ShoppingList(id);
    }

}
