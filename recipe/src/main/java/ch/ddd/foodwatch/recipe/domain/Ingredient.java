package ch.ddd.foodwatch.recipe.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder(toBuilder = true)
public class Ingredient {
    private final FoodId food;
    private final UnitQuantity unitQuantity;
}
