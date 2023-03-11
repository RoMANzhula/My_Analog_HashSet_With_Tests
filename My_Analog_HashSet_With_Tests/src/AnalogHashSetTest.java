
import org.junit.Assert;
import org.junit.Test;

public class AnalogHashSetTest {

    @Test
    public void add() {
        AnalogHashSet analogHashSet = new AnalogHashSet();
        var result = analogHashSet.add("back!");
        var expected = true;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void remove() {
        AnalogHashSet analogHashSet = new AnalogHashSet();
        analogHashSet.add("!");
        analogHashSet.add("3");
        analogHashSet.add("2");
        analogHashSet.add("1");

        var result = analogHashSet.remove("!");
        Assert.assertTrue(result);
    }

    @Test
    public void size() {
        AnalogHashSet analogHashSet = new AnalogHashSet();
        analogHashSet.add("!");
        analogHashSet.add("3");
        analogHashSet.add("2");
        analogHashSet.add("1");

        var result = analogHashSet.size();
        var expected = 4;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void contains() {
        AnalogHashSet analogHashSet = new AnalogHashSet();
        analogHashSet.add("!");
        Assert.assertTrue(analogHashSet.contains("!"));
    }
}