package ch.ddd.foodwatch.recipe.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class IngredientDto {
    private String foodId;
    private String name;
    private String quantity;
}
