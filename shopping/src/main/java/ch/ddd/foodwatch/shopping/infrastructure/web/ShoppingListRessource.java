package ch.ddd.foodwatch.shopping.infrastructure.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/shoppingLists", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShoppingListRessource {
}
