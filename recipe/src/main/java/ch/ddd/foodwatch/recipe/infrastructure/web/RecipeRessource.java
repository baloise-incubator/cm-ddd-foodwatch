package ch.ddd.foodwatch.recipe.infrastructure.web;

import ch.ddd.foodwatch.recipe.api.dto.RecipeDto;
import ch.ddd.foodwatch.recipe.domain.Recipe;
import ch.ddd.foodwatch.recipe.domain.RecipeId;
import ch.ddd.foodwatch.recipe.infrastructure.persistence.RecipeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/recipes/{recipeId}", produces = MediaType.APPLICATION_JSON_VALUE)
public class RecipeRessource {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeRessource(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping
    public RecipeDto getRecipeById(@PathVariable("recipeId") int recipeId) {
        return map(recipeRepository.findRecipeById(new RecipeId(recipeId)));
    }

    private RecipeDto map(Recipe recipe) {
        return new RecipeDto(recipe.getRecipeId().getValue());
    }

}
