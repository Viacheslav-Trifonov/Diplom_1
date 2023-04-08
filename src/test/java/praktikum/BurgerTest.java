package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {



    @Test
    public void burgerSetBunsNotNull() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("С кунжутом", 100.F));
        assertNotNull(burger.bun);
    }

    @Test
    public void burgerAddIngredientShouldSizeNotNull() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Помидорка", 50.0F));
        assertEquals("В бугере есть только одна начинка",burger.ingredients.size(), 1);
        }

    @Test
    public void burgerRemoveIngredientsShouldSizeNull() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Помидорка", 50.0F));
        burger.removeIngredient(0);
        assertEquals("Бургер должен быть без начинки", burger.ingredients.size(), 0);
    }

    @Test
    public void burgerMoveIngredientsCheckPos() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Помидорка", 50.0F));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Огурчик", 50.0F));
        burger.moveIngredient(1, 0);
        assertEquals("Теперь первый ингридиент - Огурчик",burger.ingredients.get(0).getName(), "Огурчик");
    }

    @Test
    public void burgerCheckFullPrice() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("С кунжутом", 100.F));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Помидорка", 50.0F));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Огурчик", 50.0F));
        assertEquals("Общая стоимость бургера должна быть 300", burger.getPrice(), 300.0F, 0);
    }

    @Mock
    Bun bun;

    final String RESULT_RECEIPT = String.format("(==== Булочка ====)%n" +
            "= sauce Кетчуп =%n"+
            "= filling Лук =%n"+
            "(==== Булочка ====)%n"+
            "%n"+
            "Price: 310,000000%n");

    @Test
    public void burgerCheckReceipt() {
        Mockito.when(bun.getName()).thenReturn("Булочка");
        Mockito.when(bun.getPrice()).thenReturn(100.0F);
        Burger burger = new Burger();
        burger.setBuns(bun);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient(IngredientType.SAUCE, "Кетчуп", 100.0F));
        ingredients.add(new Ingredient(IngredientType.FILLING, "Лук", 10.0F));
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
        assertEquals(" Вывод рецепта неверный", RESULT_RECEIPT, burger.getReceipt());
    }
}


