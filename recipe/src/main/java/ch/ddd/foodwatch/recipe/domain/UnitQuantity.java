package ch.ddd.foodwatch.recipe.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder(toBuilder = true)
public class UnitQuantity {
    private final Integer quantity;
    private final Unit unit;
}
