package ch.ddd.foodwatch.recipe.domain;

import lombok.Data;

@Data
public class FoodId {
    private final String id;

    public static FoodId ofId(String id) {
        return new FoodId(id);
    }
}
