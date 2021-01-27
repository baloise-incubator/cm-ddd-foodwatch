package ch.ddd.foodwatch.recipe.api.dto;

public class RecipeDto {
    private int recipeId;

    public RecipeDto(){this(0);}
    public RecipeDto(int recipeId){ this.recipeId = recipeId;}

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }
}
