package ch.ddd.foodwatch.recipe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FoodwatchRecipeApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void recipesResource_shows_the_example_recipe() throws Exception {
        mockMvc.perform(get("/recipes")
                .contentType("application/json"))
                .andExpect(content().json("[{'servings':4}]"))
                .andExpect(status().isOk());
    }

    @Test
    void createShoppingList_for_example_returns_some_id() throws Exception {
        mockMvc.perform(post("/create-shopping-list")
                .param("recipe-id", "some-recipe"))
                .andExpect(content().string(containsString("some-shopping-list-id")))
                .andExpect(status().is2xxSuccessful());
    }
}
