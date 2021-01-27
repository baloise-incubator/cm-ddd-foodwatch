package ch.ddd.foodwatch.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
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
    void contextLoads() {
    }


    @Test
    void testShoppingGenerationByRecipeId() throws Exception {
//        var shoppingList = new ShoppingListDto(new ShoppingListIdDto(), new ArrayList<>());
//        Gson gson = new Gson();
//        var contentAsJson = gson.toJson(shoppingList);
//        this.mockMvc.perform(post("/shoppingLists")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(contentAsJson))
//                .andDo(print())
//                .andExpect(content().json(gson.toJson(new ShoppingListIdDto())));
    }

}
