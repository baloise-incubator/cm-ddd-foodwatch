package ch.ddd.foodwatch.recipe.infrastructure.web;

import ch.ddd.foodwatch.recipe.domain.Recipe;
import ch.ddd.foodwatch.recipe.infrastructure.persistence.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/recipes", produces = MediaType.APPLICATION_JSON_VALUE)
public class RecipeRessource {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeRessource(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping
    public List<Recipe> getAllRecipies() {
        return recipeRepository.findAllRecipes();
    }
}
