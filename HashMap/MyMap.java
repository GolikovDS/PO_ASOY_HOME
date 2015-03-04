package HashMap;

/**
 * Created by User on 04.03.2015.
 */
public interface MyMap<K, V> {

    V get(K key);

    void put(K key, V value);

    void remove(K key);

    int size();

}
