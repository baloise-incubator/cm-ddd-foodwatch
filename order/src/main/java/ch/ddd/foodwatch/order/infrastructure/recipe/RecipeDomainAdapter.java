package ch.ddd.foodwatch.order.infrastructure.recipe;

import ch.ddd.foodwatch.recipe.domain.Ingredient;
import ch.ddd.foodwatch.recipe.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeDomainAdapter {

    public Recipe findRecipeById(String recipId) {
        //TODO call recipe service
        var ingredients = List.of(Ingredient.builder().build());
        var recipe = Recipe.builder()
                .ingredientList(ingredients)
                .build();
        return recipe;
    }
}