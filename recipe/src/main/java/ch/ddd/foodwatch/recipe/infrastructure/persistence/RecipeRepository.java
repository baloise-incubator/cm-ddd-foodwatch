package ch.ddd.foodwatch.recipe.infrastructure.persistence;

import org.springframework.stereotype.Repository;

import ch.ddd.foodwatch.recipe.domain.FoodId;
import ch.ddd.foodwatch.recipe.domain.Ingredient;
import ch.ddd.foodwatch.recipe.domain.Recipe;
import ch.ddd.foodwatch.recipe.domain.RecipeId;
import ch.ddd.foodwatch.recipe.domain.RecipeStep;
import ch.ddd.foodwatch.recipe.domain.Unit;
import ch.ddd.foodwatch.recipe.domain.UnitQuantity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class RecipeRepository {

    private final List<Recipe> recipes = new ArrayList<>();

    public RecipeRepository() {
        recipes.add(createExampleRecipe());
    }

    public Recipe createExampleRecipe() {
        return Recipe.builder()
                .recipeId(new RecipeId(1))
                .servings(4)
                .ingredientList(List.of(
                        Ingredient.builder().food(FoodId.ofId("penne"))
                                .unitQuantity(UnitQuantity.builder().quantity(400).unit(Unit.GRAMM).build())
                                .build()
                ))
                .recipeSteps(List.of(
                        RecipeStep.builder().stepNumber(1).instruction("Den Ofen auf 200 °C (Umluft 180 °C) vorheizen.").build(),
                        RecipeStep.builder().stepNumber(2).instruction("Die Zwiebel und den Knoblauch sehr fein schneiden. Die Chilischote entkernen und ebenso fein hacken. Die Kirschtomaten waschen und halbieren. Den Parmesan reiben und den Mozzarella grob würfeln. Die Basilikumblätter abzupfen, waschen und trocken tupfen.").build()
                ))
                .build();
    }

    public List<Recipe> findAllRecipes() {
        return Collections.unmodifiableList(recipes);
    }


    public Recipe findRecipeById(RecipeId recipeId) {
        return recipes.get(0);  // TODO implement recipe ids
    }
}
