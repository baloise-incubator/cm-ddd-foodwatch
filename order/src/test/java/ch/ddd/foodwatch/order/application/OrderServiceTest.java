package ch.ddd.foodwatch.order.application;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ch.ddd.foodwatch.order.infrastructure.recipe.RecipeDomainAdapter;
import ch.ddd.foodwatch.order.infrastructure.shopping.ShoppingDomainAdapter;
import ch.ddd.foodwatch.recipe.api.dto.RecipeDto;

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

        // var ingredients = List.of(Ingredient.builder().build());
        var recipe = new RecipeDto(1);

        when(recipeDomainAdapter.findRecipeById(recipeId))
                .thenReturn(recipe);
        // when(shoppingDomainAdapter.createShoppingList(ingredients))
        // .thenReturn("some-id");

        String shoppingListId = cut.createShoppingListForRecipeWithId(recipeId);

        assertThat(shoppingListId, is("some-id"));
    }
}
