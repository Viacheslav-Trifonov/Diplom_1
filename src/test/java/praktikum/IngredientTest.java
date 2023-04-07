package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;


public class IngredientTest {

    @Test
    public void ingredientGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"Майонез", 100.0F);
        assertEquals(ingredient.getName(), "Майонез");
    }

    @Test
    public void ingredientGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"Майонез", 100.0F);
        assertEquals(ingredient.getPrice(), 100.0F, 0);
    }

    @Test
    public void ingredientGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"Майонез", 100.0F);
        assertEquals(ingredient.getType(), IngredientType.SAUCE);
    }

}
