package ch.ddd.foodwatch.order.infrastructure.persistence;

import ch.ddd.foodwatch.order.domain.Order;
import ch.ddd.foodwatch.order.domain.OrderId;
import org.springframework.stereotype.Component;

@Component
public class OrderRepository {

    public Order get(OrderId id) {
        return new Order(id);
    }

}
