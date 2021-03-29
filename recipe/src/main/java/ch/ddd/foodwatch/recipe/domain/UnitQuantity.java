package ch.ddd.foodwatch.recipe.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class UnitQuantity {
    private final Integer quantity;
    private final Unit unit;
}
