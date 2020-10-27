package ch.ddd.foodwatch.order.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Order {
    private final OrderId orderId;
}
