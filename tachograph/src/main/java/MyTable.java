import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class MyTable {
    public Table<Integer, Integer, Integer> myTable;

public MyTable() {
    myTable = HashBasedTable.create();
    myTable.put(1, 2, 3);
    myTable.put(2, 7, 6);
    myTable.put(3, 1, 4);
    myTable.put(4,3,7);
}


}
