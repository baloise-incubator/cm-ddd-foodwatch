package ch.ddd.foodwatch.shopping.application;

import ch.ddd.foodwatch.shopping.domain.ShoppingList;
import ch.ddd.foodwatch.shopping.domain.ShoppingListId;
import ch.ddd.foodwatch.shopping.infrastructure.persistence.ShoppingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ShoppingListService {

    private final ShoppingRepository shoppingRepository;

    public ShoppingListService(ShoppingRepository shoppingRepository) {
        this.shoppingRepository = shoppingRepository;
    }

    public ShoppingListId createNewShoppingListWithItems(/* TODO items */) {
        return shoppingRepository.createNewShoppingList();
    }

    public ShoppingList findById(ShoppingListId shoppingListId) {
        return shoppingRepository.get(shoppingListId);
    }

    public List<ShoppingList> findAllShoppingLists() {
        return shoppingRepository.findAll();
    }
}
