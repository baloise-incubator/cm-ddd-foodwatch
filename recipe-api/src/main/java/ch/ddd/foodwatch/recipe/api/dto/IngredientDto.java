package ch.ddd.foodwatch.recipe.api.dto;

import lombok.Data;

@Data
public class IngredientDto {
    private final int foodId;
    private final String name;
    private final String quantity;
}
