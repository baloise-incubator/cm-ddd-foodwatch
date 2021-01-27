package ch.ddd.foodwatch.food.application;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import ch.ddd.foodwatch.food.domain.Food;
import ch.ddd.foodwatch.food.infrastructure.edamame.ApiAdapter;

@Service
@AllArgsConstructor
public class FoodService {
    private final ApiAdapter edamameAdapter;

    public Food getFoodByName(String name){
        return edamameAdapter.getFoodByName(name);
    }

}
