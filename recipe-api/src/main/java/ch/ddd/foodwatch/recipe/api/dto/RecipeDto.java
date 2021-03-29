package ch.ddd.foodwatch.recipe.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeDto {
    private int recipeId;
    private int serves;
    private List<IngredientDto> ingredients;
}
