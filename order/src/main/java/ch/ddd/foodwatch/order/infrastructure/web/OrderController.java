package ch.ddd.foodwatch.order.infrastructure.web;

import ch.ddd.foodwatch.order.application.OrderService;
import ch.ddd.foodwatch.recipe.domain.RecipeId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/create-shopping-list")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public String createShoppingList(@RequestParam("recipe-id") RecipeId recipeId, Model model) {
        String shoppingListId = orderService.createShoppingListForRecipeWithId(recipeId);
        model.addAttribute("shoppingListId", shoppingListId);
        return "create-shopping-list-result";
    }
}
