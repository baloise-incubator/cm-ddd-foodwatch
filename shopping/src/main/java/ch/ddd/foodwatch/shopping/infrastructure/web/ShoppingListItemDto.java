package ch.ddd.foodwatch.shopping.infrastructure.web;

import lombok.Data;

@Data
public class ShoppingListItemDto {
    private final FoodIdDto foodIdDto;
    private final AmountDto amount;
}
