package ch.ddd.foodwatch.shopping.api.dto;

import lombok.Data;

@Data
public class ShoppingListItemDto {
    private final FoodIdDto foodIdDto;
    private final AmountDto amount;
}
