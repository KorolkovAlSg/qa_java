import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    private Cat cat;

    @Mock
    private Feline felineMock;

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

    @Test
    public void otherTestGetFoodWithMockReturnList() throws Exception {
        cat = new Cat(felineMock);
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Трава", "Различные растения"));
        Assert.assertEquals("Метод должен вернуть список - \"Трава\", \"Различные растения\"", List.of("Трава", "Различные растения"), cat.getFood());
    }

}
