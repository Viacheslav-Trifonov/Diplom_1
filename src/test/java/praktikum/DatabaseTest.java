package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DatabaseTest {
    Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void availableBunTest()  {
        List<Bun> bun = database.availableBuns();
        Assert.assertFalse(bun.isEmpty());
    }

    @Test
    public void availableIngredientsTest() {
        List<Ingredient> ingredients = database.availableIngredients();
        Assert.assertFalse(ingredients.isEmpty());
    }
}

