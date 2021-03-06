package ch.ddd.foodwatch.recipe.infrastructure.web;

import ch.ddd.foodwatch.recipe.api.dto.IngredientDto;
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
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping(value = "/recipes", produces = MediaType.APPLICATION_JSON_VALUE)
public class RecipeResource {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeResource(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping
    public List<RecipeDto> findAllRecipies() {
        return recipeRepository.findAllRecipes().stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{recipeId}")
    public RecipeDto getRecipeById(@PathVariable("recipeId") int recipeId) {
        Optional<Recipe> maybeRecipe = recipeRepository.findRecipeById(new RecipeId(recipeId));
        return map(maybeRecipe.orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Recipe does not exist")));
    }

    private RecipeDto map(Recipe recipe) {
        return RecipeDto.builder()
                .recipeId(recipe.getRecipeId().getValue())
                .serves(recipe.getServings())
                .ingredients(
                        recipe.getIngredientList().stream()
                                .map(ingredient ->
                                        new IngredientDto(ingredient.getFood().getId(), "",
                                                ingredient.getUnitQuantity().toString()))
                                .collect(Collectors.toList())
                )
                .build();
    }

}
