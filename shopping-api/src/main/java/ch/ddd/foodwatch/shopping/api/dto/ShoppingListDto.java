package ch.ddd.foodwatch.shopping.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingListDto {
    private ShoppingListIdDto shoppingListIdDto;
    private List<ShoppingListItemDto> foodIdDto;
}
