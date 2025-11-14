import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;


public class LionTest {

    private Lion lion;

    @Before
    public void setVar() throws Exception {
        Feline feline = new Feline();
        lion = new Lion("Самец", feline);
    }

    @Test
    public void getFoodInvokeReturnList() throws Exception {
        Assert.assertEquals("Метод должен вернуть список - \"Животные\", \"Птицы\", \"Рыба\"", List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void getKittensInvokeReturnInt1(){
        Assert.assertEquals("Метод должен вернуть 1", 1,lion.getKittens());
    }

}
