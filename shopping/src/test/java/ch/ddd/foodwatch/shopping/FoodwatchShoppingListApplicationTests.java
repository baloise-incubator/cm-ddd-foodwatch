package ch.ddd.foodwatch.shopping;

import ch.ddd.foodwatch.shopping.api.dto.ShoppingListDto;
import ch.ddd.foodwatch.shopping.api.dto.ShoppingListIdDto;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FoodwatchShoppingListApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testShoppingListGenerationByRecipeId() throws Exception {
        var shoppingList = new ShoppingListDto(new ShoppingListIdDto(), new ArrayList<>());
        Gson gson = new Gson();
        var contentAsJson = gson.toJson(shoppingList);
        this.mockMvc.perform(post("/shoppingLists")
                .contentType(MediaType.APPLICATION_JSON)
                .content(contentAsJson))
                .andDo(print())
                .andExpect(content().json(gson.toJson(new ShoppingListIdDto())));
    }

    @Test
    void invalid_id_gives_404() throws Exception {
        String invalidId = UUID.randomUUID().toString();
        this.mockMvc.perform(get("/shoppingLists/" + invalidId))
                .andExpect(status().isNotFound());
    }
}
