import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void reorganizeStringTest1() {
        String s = "aab";
        String expected = "aba";
        String actual = new Solution().reorganizeString(s);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reorganizeStringTest2() {
        String s = "aaab";
        String expected = "";
        String actual = new Solution().reorganizeString(s);

        Assert.assertEquals(expected, actual);
    }
}
