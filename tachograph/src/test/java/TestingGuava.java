import com.google.common.collect.Table;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class TestingGuava {

    Table myTable;
    @Before
    public void before() {
        MyTable table = new MyTable();
        myTable= table.myTable;
    }

    @Test
    public void OverridingJoystickPosition_IncreasesReferenceSpeed() {
        Assert.assertEquals(4, myTable.size());
    }
}
