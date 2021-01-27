package ch.ddd.foodwatch.food.infrastructure.edamame;

import lombok.Data;

import java.util.List;

@Data
public class EdamameFood {
    private String text;
    private List<EdamameFoodItem> parsed;
}
