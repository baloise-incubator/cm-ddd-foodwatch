package ch.ddd.foodwatch.order.infrastructure.web;

import ch.ddd.foodwatch.order.domain.Order;
import ch.ddd.foodwatch.order.domain.OrderId;
import ch.ddd.foodwatch.order.infrastructure.persistence.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderRessource {

    private final OrderRepository repository;

    @Autowired
    public OrderRessource(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/{orderId}")
    public Order getOrderById(@PathVariable String orderId) {
        return repository.get(new OrderId(UUID.fromString(orderId)));
    }

//    @PostMapping
//    public ShoppingListIdDto createNewShoppingList(@RequestBody ShoppingListDto shoppingListId) {
//        return new ShoppingListIdDto();
//    }

}
