package ch.ddd.foodwatch.food.infrastructure.web;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FoodDto {
    private String id;
    private String name;
    private String category;
    private String imageUrl;
}
