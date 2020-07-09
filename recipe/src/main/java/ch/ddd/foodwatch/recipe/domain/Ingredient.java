package ch.ddd.foodwatch.recipe.domain;

import ch.ddd.foodwatch.food.domain.Food;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder(toBuilder = true)
public class Ingredient {
    private final Food food;
    private final Integer quantity;
    private final Unit unit;
}
