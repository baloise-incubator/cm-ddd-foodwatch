package ch.ddd.foodwatch.recipe.application;

import ch.ddd.foodwatch.recipe.domain.Ingredient;
import ch.ddd.foodwatch.recipe.domain.Recipe;
import ch.ddd.foodwatch.recipe.domain.RecipeId;
import ch.ddd.foodwatch.recipe.infrastructure.persistence.RecipeRepository;
import ch.ddd.foodwatch.recipe.infrastructure.shopping.ShoppingDomainAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class CreateShoppingListServiceTest {

    private CreateShoppingListService cut;

    @Mock
    private ShoppingDomainAdapter shoppingDomainAdapter;

    @Mock
    private RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        initMocks(this);
        cut = new CreateShoppingListService(shoppingDomainAdapter, recipeRepository);
    }

    @Test
    void service_calls_shopping_adapter_with_ingredients() {
        var recipeId = new RecipeId("some-recipe-id");
        var expectedShoppingListId = "some-shopping-list-id";

        var ingredients = List.of(Ingredient.builder().build());
        var recipe = Recipe.builder()
                .ingredientList(ingredients)
                .build();

        when(recipeRepository.findRecipeById(recipeId))
                .thenReturn(recipe);
        when(shoppingDomainAdapter.createShoppingList(ingredients))
                .thenReturn("some-id");

        String shoppingListId = cut.createShoppingListForRecipeWithId(recipeId);

        assertThat(shoppingListId, is("some-id"));
    }
}