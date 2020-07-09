package ch.ddd.foodwatch.food.domain;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FoodId {
    private final UUID id;
}
