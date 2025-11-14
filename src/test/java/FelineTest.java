import com.example.Feline;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private Feline feline;

    @Spy
    private Feline felineSpy = new Feline();

    @Before
    public void setVar(){
        feline = new Feline();
    }

    @Test
    public void eatMeatInvokeOneTimeReturnList() throws Exception {
        Assert.assertEquals("Метод должен вернуть список - \"Животные\", \"Птицы\", \"Рыба\"", List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getFamilyInvokeOneTimeReturnString(){
        Assert.assertEquals("Метод должен вернуть - Кошачьи", "Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensParam10Return10(){
        Assert.assertEquals("Метод должен вернуть - 10", 10, feline.getKittens(10));
    }

    @Test
    public void getKittensNoParamInvokeSetKittensWith1(){
        felineSpy.getKittens();
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(1);
    }


}
