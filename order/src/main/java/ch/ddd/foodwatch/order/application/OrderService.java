package ch.ddd.foodwatch.order.application;


import ch.ddd.foodwatch.order.infrastructure.recipe.RecipeDomainAdapter;
import ch.ddd.foodwatch.order.infrastructure.shopping.ShoppingDomainAdapter;
import ch.ddd.foodwatch.recipe.domain.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ShoppingDomainAdapter shoppingDomainAdapter;
    private final RecipeDomainAdapter recipeDomainAdapter;

    @Autowired
    public OrderService(ShoppingDomainAdapter shoppingDomainAdapter, RecipeDomainAdapter recipeDomainAdapter) {
        this.shoppingDomainAdapter = shoppingDomainAdapter;
        this.recipeDomainAdapter = recipeDomainAdapter;
    }

    public String createShoppingListForRecipeWithId(String recipeId) {
        Recipe recipe = recipeDomainAdapter.findRecipeById(recipeId);
        return shoppingDomainAdapter.createShoppingList(recipe.getIngredientList());
    }
}
