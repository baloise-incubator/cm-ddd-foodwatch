package ch.ddd.foodwatch.order.infrastructure.recipe;

import ch.ddd.foodwatch.recipe.domain.Ingredient;
import ch.ddd.foodwatch.recipe.domain.Recipe;
import ch.ddd.foodwatch.recipe.domain.RecipeId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecipeDomainAdapter {

    public Recipe findRecipeById(RecipeId recipId) {
        //TODO call recipe service
        var ingredients = List.of(Ingredient.builder().build());
        var recipe = Recipe.builder()
                .ingredientList(ingredients)
                .build();
        return recipe;
    }
}
