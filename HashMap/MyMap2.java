package HashMap;

/**
 * Created by Дмитрий on 04.03.2015.
 */
public interface MyMap2<K, V> {
    V get(K key);

    void put(K key, V value);

    void remove(K key);

    int size();

}
