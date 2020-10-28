package ch.ddd.foodwatch.order.infrastructure.web;

import ch.ddd.foodwatch.order.application.CreateShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/create-shopping-list")
public class CreateShoppingListController {

    private final CreateShoppingListService createShoppingListService;

    @Autowired
    public CreateShoppingListController(CreateShoppingListService createShoppingListService) {
        this.createShoppingListService = createShoppingListService;
    }

    @GetMapping
    public String start(Model model) {
        return "create-shopping-list-start";
    }

//    @PostMapping
//    public String createShoppingList(@RequestParam("recipe-id") String recipeId, Model model) {
//        String shoppingListId = createShoppingListService.createShoppingListForRecipeWithId(recipeId);
//        model.addAttribute("shoppingListId", shoppingListId);
//        return "create-shopping-list-result";
//    }
}
