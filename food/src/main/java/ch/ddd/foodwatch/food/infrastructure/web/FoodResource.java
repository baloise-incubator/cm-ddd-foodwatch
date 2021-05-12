package ch.ddd.foodwatch.food.infrastructure.web;

import lombok.AllArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.ddd.foodwatch.food.application.FoodService;
import ch.ddd.foodwatch.food.domain.Food;

@RestController
@RequestMapping(value = "/foods", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class FoodResource {

    private final FoodService foodService;

    @GetMapping
    public FoodDto findFoodByName(@RequestParam("name") String name) {
        return map(foodService.getFoodByName(name));
    }

    private FoodDto map(Food foodByName) {
        return new FoodDto(foodByName.getFoodId().getId().toString(), foodByName.getName(), foodByName.getCategory(), foodByName.getImageUrl(), foodByName.getEdamameId());
    }
}
