package ch.ddd.foodwatch.shopping.infrastructure.web;

import ch.ddd.foodwatch.shopping.api.dto.ShoppingListDto;
import ch.ddd.foodwatch.shopping.api.dto.ShoppingListIdDto;
import ch.ddd.foodwatch.shopping.domain.ShoppingList;
import ch.ddd.foodwatch.shopping.domain.ShoppingListId;
import ch.ddd.foodwatch.shopping.infrastructure.persistence.ShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/shoppingLists", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShoppingListRessource {

    private final ShoppingRepository repository;

    @Autowired
    public ShoppingListRessource(ShoppingRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/{shoppingListId}")
    public ShoppingList getShoppingListById(@PathVariable String shoppingListId) {
        return repository.get(new ShoppingListId(UUID.fromString(shoppingListId)));
    }

    @PostMapping
    public ShoppingListIdDto createNewShoppingList(@RequestBody ShoppingListDto shoppingList) {
        return new ShoppingListIdDto();
    }

}
