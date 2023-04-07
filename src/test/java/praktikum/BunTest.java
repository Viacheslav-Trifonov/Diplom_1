package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class BunTest {
    String name;
    float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"", 0},
                {null, 777},
                {"@@@********", -999}
        };
    }
    @Test
    public void bunGetPrice() {
        Bun bun  = new Bun(name, price);
        assertEquals("Цена неверная", bun.getPrice(), price, 0);
    }

    @Test
    public void bunGetName() {
        Bun bun  = new Bun(name, price);
        assertEquals("Название неверно", bun.getName(), name);
    }

}
