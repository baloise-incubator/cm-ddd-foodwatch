package ch.ddd.foodwatch.shopping.infrastructure.web;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.ddd.foodwatch.shopping.domain.ShoppingList;
import ch.ddd.foodwatch.shopping.domain.ShoppingListId;
import ch.ddd.foodwatch.shopping.infrastructure.persistence.ShoppingRepository;

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
