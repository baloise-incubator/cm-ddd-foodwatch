package ch.ddd.foodwatch.order.infrastructure.recipe;


import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import ch.ddd.foodwatch.recipe.api.dto.RecipeDto;

@Component
public class RecipeDomainAdapter {

    public RecipeDto findRecipeById(int recipeId) {
        WebClient client2 = WebClient.create("http://localhost:8082");
        WebClient.RequestBodySpec uri1 = client2
                .method(HttpMethod.GET)
                .uri("/recipes/"+recipeId);
        return uri1.retrieve()
                .bodyToMono(RecipeDto.class)
                .block();
    }
}
