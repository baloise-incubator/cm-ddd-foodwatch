package ch.ddd.foodwatch.recipe.infrastructure.persistence;

import ch.ddd.foodwatch.recipe.domain.Recipe;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class RecipeRepository {

    private List<Recipe> recipes = new ArrayList<>();

    public List<Recipe> findAllRecipes() {
        return Collections.unmodifiableList(recipes);
    }
}
