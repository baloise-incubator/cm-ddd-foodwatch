package ch.ddd.foodwatch.order.infrastructure.web;

import lombok.Data;

@Data
public class OrderDto {
    private final OrderIdDto orderIdDto;
    //TODO add ShoppingList -> call shoping service
    //private final List<ShoppingListItemDto> foodIdDto;
}
