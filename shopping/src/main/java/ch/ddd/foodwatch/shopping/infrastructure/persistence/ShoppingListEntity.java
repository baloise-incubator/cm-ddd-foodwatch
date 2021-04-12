package ch.ddd.foodwatch.shopping.infrastructure.persistence;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "SHOPPING_LIST")
class ShoppingListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
}
