package ch.ddd.foodwatch.recipe.application;

import ch.ddd.foodwatch.recipe.domain.Recipe;
import ch.ddd.foodwatch.recipe.domain.RecipeId;
import ch.ddd.foodwatch.recipe.infrastructure.persistence.RecipeRepository;
import ch.ddd.foodwatch.recipe.infrastructure.shopping.ShoppingDomainAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateShoppingListService {

    private final ShoppingDomainAdapter shoppingDomainAdapter;
    private final RecipeRepository recipeRepository;

    @Autowired
    public CreateShoppingListService(ShoppingDomainAdapter shoppingDomainAdapter, RecipeRepository recipeRepository) {
        this.shoppingDomainAdapter = shoppingDomainAdapter;
        this.recipeRepository = recipeRepository;
    }

    public String createShoppingListForRecipeWithId(RecipeId recipeId) {
        Recipe recipe = recipeRepository.findRecipeById(recipeId);
        return shoppingDomainAdapter.createShoppingList(recipe.getIngredientList());
    }
}
