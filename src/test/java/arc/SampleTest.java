package arc;



import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest {

    @Test
    public void sampleAdditionTest() {
        int result = 2 + 3;
        Assert.assertEquals(result, 5, "Expected result is 5");
    }

    @Test
    public void sampleFailingTest() {
        Assert.assertTrue(false, "Intentional failure for demo");
    }
}

