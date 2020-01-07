package pssc.flybuy;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class FlybuyApplicationMainTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test(expected = Test.None.class)
    public void testMainApplication(){
        expectedException.reportMissingExceptionWithMessage("No exception should be thrown here");
        FlybuyApplication.main(new String[]{});
    }
}
