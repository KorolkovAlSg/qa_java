import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionWithParamTest {

    private Feline feline;

    private final String sex;
    private final boolean hasMane;
    private final String exceptThrows;

    public LionWithParamTest(String sex, boolean hasMane, String exceptThrows) {
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
        new Lion(exceptThrows, feline);
    }

    @Test
    public void createObjWithCorrectVarAndSetHasManeReturnHasMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals("Метод должен вернуть true - если особь самец; false - если самка", hasMane, lion.doesHaveMane());
    }
}
