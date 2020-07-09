package ch.ddd.foodwatch.shopping.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class ShoppingListId {
    private final UUID id;
}
