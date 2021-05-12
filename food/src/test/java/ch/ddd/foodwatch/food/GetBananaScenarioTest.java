package ch.ddd.foodwatch.food;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.ddd.foodwatch.food.infrastructure.web.FoodDto;

@ExtendWith(SpringExtension.class)
@ActiveProfiles(value = "dev")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GetBananaScenarioTest {

    @Autowired
    private WebApplicationContext context;

    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void test() throws Exception {
        final FoodDto expectedFoodItem = new FoodDto("7fde4b90-a766-43b1-802c-17f097e2dbe4",
                "banana",
                "Generic foods",
                "https://www.edamam.com/food-img/9f6/9f6181163a25c96022ee3fc66d9ebb11.jpg",
                "food_bjsfxtcaidvmhaa3afrbna43q3hu");
        final String endpoint = "/foods?name=banana";
        final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(endpoint)
                .accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andReturn();

        final String contentAsString = mvcResult.getResponse().getContentAsString();
        final FoodDto foodResult = objectMapper.readValue(contentAsString, FoodDto.class);

        assertEquals(expectedFoodItem.getName(), foodResult.getName());
        assertEquals(expectedFoodItem.getCategory(), foodResult.getCategory());
        assertEquals(expectedFoodItem.getImageUrl(), foodResult.getImageUrl());
        assertEquals(expectedFoodItem.getEdamameId(), foodResult.getEdamameId());
    }
}
