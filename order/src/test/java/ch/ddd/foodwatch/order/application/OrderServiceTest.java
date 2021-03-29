package ch.ddd.foodwatch.order.application;

import ch.ddd.foodwatch.order.infrastructure.recipe.RecipeDomainAdapter;
import ch.ddd.foodwatch.order.infrastructure.shopping.ShoppingDomainAdapter;
import ch.ddd.foodwatch.recipe.api.dto.IngredientDto;
import ch.ddd.foodwatch.recipe.api.dto.RecipeDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class OrderServiceTest {
    private ch.ddd.foodwatch.order.application.OrderService cut;

    @Mock
    private ShoppingDomainAdapter shoppingDomainAdapter;

    @Mock
    private RecipeDomainAdapter recipeDomainAdapter;

    @BeforeEach
    void setUp() {
        initMocks(this);
        cut = new OrderService(shoppingDomainAdapter, recipeDomainAdapter);
    }

    @Test
    void service_calls_shopping_adapter_with_ingredients() {
        var recipeId = 1;

        var ingredients = List.of(IngredientDto.builder().build());
        var recipe = new RecipeDto(recipeId, 2, ingredients);

        when(recipeDomainAdapter.findRecipeById(recipeId))
                .thenReturn(recipe);
        when(shoppingDomainAdapter.createShoppingList(ingredients))
                .thenReturn("some-id");

        String shoppingListId = cut.createShoppingListForRecipeWithId(recipeId);

        assertThat(shoppingListId, is("some-id"));
    }
}
