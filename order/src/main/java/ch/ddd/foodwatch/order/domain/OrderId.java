package ch.ddd.foodwatch.order.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class OrderId {
    private final UUID id;
}
