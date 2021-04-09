package ch.ddd.foodwatch.shopping.infrastructure.web;

import ch.ddd.foodwatch.shopping.api.dto.ShoppingListDto;
import ch.ddd.foodwatch.shopping.api.dto.ShoppingListIdDto;
import ch.ddd.foodwatch.shopping.application.ShoppingListService;
import ch.ddd.foodwatch.shopping.domain.ShoppingList;
import ch.ddd.foodwatch.shopping.domain.ShoppingListId;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/shoppingLists", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShoppingListResource {

    private final ShoppingListService shoppingListService;

    public ShoppingListResource(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @GetMapping
    public List<ShoppingList> getAllShoppingLists() {
        return shoppingListService.findAllShoppingLists();
    }

    @GetMapping(path = "/{shoppingListId}")
    public ShoppingList getShoppingListById(@PathVariable String shoppingListId) {
        return shoppingListService.findById(new ShoppingListId(UUID.fromString(shoppingListId)));
    }

    @PostMapping
    public ResponseEntity<ShoppingListDto> createNewShoppingList(@RequestBody ShoppingListDto shoppingList) {
        ShoppingListId createdID = shoppingListService.createNewShoppingListWithItems(/* TODO items */);
        ShoppingList createdList = shoppingListService.findById(createdID);
        return ResponseEntity.created(URI.create("/shoppingLists/" + createdID.getId().toString()))
                .body(map(createdList));
    }

    private ShoppingListDto map(ShoppingList shoppingList) {
        ShoppingListDto dto = new ShoppingListDto();
        dto.setShoppingListIdDto(new ShoppingListIdDto(shoppingList.getShoppingListId().getId().toString()));
        // TODO more mapping ...
        return dto;
    }

}
