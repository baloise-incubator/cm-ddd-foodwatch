package ch.ddd.foodwatch.shopping.infrastructure.web;

import lombok.Data;

import java.util.List;

@Data
public class ShoppingListDto {
    private final ShoppingListIdDto shoppingListIdDto;
    private final List<ShoppingListItemDto> foodIdDto;
}
