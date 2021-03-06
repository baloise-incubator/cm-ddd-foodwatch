package ch.ddd.foodwatch.recipe.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder(toBuilder = true)
public class Recipe {
    private final RecipeId recipeId;
    private final Integer servings;
    private final List<Ingredient> ingredientList;
    private final List<RecipeStep> recipeSteps;
}
