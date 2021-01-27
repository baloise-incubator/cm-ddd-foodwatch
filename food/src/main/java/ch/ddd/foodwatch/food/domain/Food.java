package ch.ddd.foodwatch.food.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Food {
    private final FoodId foodId;
    private final String name;
    private final String category;
    private final String imageUrl;
}
