import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void getFamilyInvokeOneTimeReturnString(){
        Assert.assertEquals("Метод должен вернуть - Кошачьи", "Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensParam10Return10(){
        Assert.assertEquals("Метод должен вернуть - 10", 10, feline.getKittens(10));
    }

    @Test
    public void getKittensNoParamInvokeGetKittensWith1(){
        Assert.assertEquals("Метод должен вернуть - 1", 1, feline.getKittens());

        // проверь, что внутри ровно один раз вызвался метод getKittens(int kittensCount)
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }
}
