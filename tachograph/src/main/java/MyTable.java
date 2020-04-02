import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class MyTable {
    public Table<Integer, Integer, Integer> table;

public MyTable() {
    table = HashBasedTable.create();
    table.put(1, 2, 3);
    table.put(2, 7, 6);
    table.put(3, 1, 4);
    table.put(4,3,7);
}


}
