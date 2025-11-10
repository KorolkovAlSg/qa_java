import com.example.Feline;
import com.example.Lion;
import com.example.Specimen;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {

    private Specimen feline;

    private final String sex;
    private final boolean hasMane;
    private final String exceptThrows;

    public LionTest(String sex, boolean hasMane, String exceptThrows) {
        this.sex = sex;
        this.hasMane = hasMane;
        this.exceptThrows = exceptThrows;
    }

    @Parameterized.Parameters(name = "Особь льва: {0}, Есть грива? - {1}, Значение для исключения - {2}")
    public static Object[][] getLionInfo(){
        return new Object[][]{
                {"Самец", true, "Мужчина"},
                {"Самка", false, "Мадам"},
        };
    }

    @Before
    public void setVar(){
        feline = new Feline();
    }

    @Test(expected=Exception.class)
    public void createObjWithExceptVarInvokeException() throws Exception {
        new Lion(exceptThrows);
    }

    @Test
    public void createObjWithCorrectVarAndSetHasManeReturnHasMane() throws Exception {
        Lion lion = new Lion(sex);
        Lion lionSpy = Mockito.spy(lion);
        Assert.assertEquals("Метод должен вернуть true - если особь самец; false - если самка", hasMane, lionSpy.doesHaveMane());

        // проверь, что внутри ровно один раз вызвался метод doesHaveMane()
        Mockito.verify(lionSpy, Mockito.times(1)).doesHaveMane();
    }

    @Test
    public void getFoodInvokeOneTimeReturnList() throws Exception {
        Lion lion = new Lion(feline);
        Lion lionSpy = Mockito.spy(lion);
        Assert.assertEquals("Метод должен вернуть список - \"Животные\", \"Птицы\", \"Рыба\"", List.of("Животные", "Птицы", "Рыба"), lionSpy.getFood());
    }

    @Test
    public void getKittensNoParam(){
        Lion lion = new Lion(feline);
        Lion lionSpy = Mockito.spy(lion);
        Assert.assertEquals("Метод должен вернуть - 1", 1,lionSpy.getKittens());
    }

}
