package ch.ddd.foodwatch.shopping.infrastructure.persistence;

import ch.ddd.foodwatch.shopping.domain.ShoppingList;
import ch.ddd.foodwatch.shopping.domain.ShoppingListId;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Repository
public class ShoppingRepository {

    private final EntityManager entityManager;

    public ShoppingRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ShoppingList get(ShoppingListId id) {
        ShoppingListEntity shoppingListEntity = entityManager.find(ShoppingListEntity.class, id.getId());
        return shoppingListEntity == null ? null :
                mapToDomain(shoppingListEntity);
    }

    private ShoppingList mapToDomain(ShoppingListEntity shoppingListEntity) {
        return new ShoppingList(new ShoppingListId(shoppingListEntity.id));
    }

    public ShoppingListId createNewShoppingList() {
        ShoppingListEntity shoppingListEntity = new ShoppingListEntity();
        entityManager.persist(shoppingListEntity);
        return new ShoppingListId(shoppingListEntity.id);
    }

    public List<ShoppingList> findAll() {
        return entityManager.createQuery("select l from ShoppingListEntity l", ShoppingListEntity.class)
                .getResultList().stream()
                .map(this::mapToDomain)
                .collect(toList());
    }
}
