package ch.ddd.foodwatch.recipe.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class RecipeDto {
    private int recipeId;
    private int serves;
    private List<IngredientDto> ingredients;
}
