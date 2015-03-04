package HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 04.03.2015.
 */
public class MyHashMap<K, V> implements MyMap2 {

    Table<K, V>[] table;
    int size;

    Map m = new HashMap();

    MyHashMap() {
        table = new Table[4];
        size = 0;
    }


    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public void put(Object key, Object value) {
        if (table.length <= size) {
            Table<K, V>[] buffTable = table;
            table = new Table[table.length + 4];
            System.out.println(table.length + "1");
            System.arraycopy(buffTable, 0, table, 0, buffTable.length);
            System.out.println(table.length + "2");
        }
        table[size] = new Table<K, V>((K) key, (V) value);
        size++;
        System.out.println(table[size - 1].kay);
    }


    @Override
    public void remove(Object key) {

    }

    @Override
    public int size() {
        return 0;
    }
}

class Table<K, V> {

    K kay;
    V value;

    Table(K setK, V setV) {
        kay = setK;
        value = setV;
    }


}