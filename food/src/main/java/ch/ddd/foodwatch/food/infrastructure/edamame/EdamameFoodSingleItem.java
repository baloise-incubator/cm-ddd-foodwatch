package ch.ddd.foodwatch.food.infrastructure.edamame;

import lombok.Data;

@Data
public class EdamameFoodSingleItem {
    private String foodId;
    private String label;
    private String category;
    private String image;
}
