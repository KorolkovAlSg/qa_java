import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CatTest {

    private Cat cat;

    @Before
    public void setVar(){
        Feline feline = new Feline();
        cat = new Cat(feline);
    }

    @Test
    public void getSoundInvokeReturnString() {
        Assert.assertEquals("Метод должен вернуть - Мяу", "Мяу", cat.getSound());
    }

    @Test
    public void getFoodInvokeReturnList() throws Exception {
        Assert.assertEquals("Метод должен вернуть список - \"Животные\", \"Птицы\", \"Рыба\"", List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }

}
