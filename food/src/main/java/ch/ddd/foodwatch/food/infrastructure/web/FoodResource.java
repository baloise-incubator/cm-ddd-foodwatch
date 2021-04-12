package ch.ddd.foodwatch.food.infrastructure.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/foods", produces = MediaType.APPLICATION_JSON_VALUE)
public class FoodResource {
}
