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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class FoodwatchShoppingListApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception {
        var id = "fcbe4529-cd46-4c02-a36b-9ba81cd98ce4";
        String expectedJsonContent = "{\"shoppingListId\":{\"id\":\"fcbe4529-cd46-4c02-a36b-9ba81cd98ce4\"}}";
        this.mockMvc.perform(get("/shoppingLists/" + id))
                .andDo(print())
                .andExpect(content().json(expectedJsonContent));
    }

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

}
