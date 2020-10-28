package ch.ddd.foodwatch.order.application;

import ch.ddd.foodwatch.order.infrastructure.recipe.RecipeDomainAdapter;
import ch.ddd.foodwatch.order.infrastructure.shopping.ShoppingDomainAdapter;
import ch.ddd.foodwatch.recipe.domain.Ingredient;
import ch.ddd.foodwatch.recipe.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class CreateShoppingListServiceTest {
    private ch.ddd.foodwatch.order.application.CreateShoppingListService cut;

    @Mock
    private ShoppingDomainAdapter shoppingDomainAdapter;

    @Mock
    private RecipeDomainAdapter recipeDomainAdapter;

    @BeforeEach
    void setUp() {
        initMocks(this);
        cut = new CreateShoppingListService(shoppingDomainAdapter, recipeDomainAdapter);
    }

    @Test
    void service_calls_shopping_adapter_with_ingredients() {
        var recipeId = "some-recipe-id";

        var ingredients = List.of(Ingredient.builder().build());
        var recipe = Recipe.builder()
                .ingredientList(ingredients)
                .build();

        when(recipeDomainAdapter.findRecipeById(recipeId))
                .thenReturn(recipe);
        when(shoppingDomainAdapter.createShoppingList(ingredients))
                .thenReturn("some-id");

        String shoppingListId = cut.createShoppingListForRecipeWithId(recipeId);

        assertThat(shoppingListId, is("some-id"));
    }
}
