import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    private Feline feline = new Feline();

    @Spy
    private Cat cat = new Cat(feline);

    @Test
    public void getSoundCallOneTimeReturnString() {
        Assert.assertEquals("Метод должен вернуть - Мяу", "Мяу", cat.getSound());
    }

    @Test
    public void getFoodCallReturnFelineGetFood() throws Exception {
        Assert.assertEquals("Метод должен вернуть список - \"Животные\", \"Птицы\", \"Рыба\"", List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }

}
