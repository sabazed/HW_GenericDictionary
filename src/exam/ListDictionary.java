package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ListDictionary<K, V> implements Dictionary<K, V> {

    // Create private attributes for both keys and values
    private List<K> keys;
    private List<V> values;

    // Constructor for initializing keys and values;
    public ListDictionary() {
        this.keys = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    // Method for returning an Option object
    @Override
    public Option<V> get(K key) {
        // Get the length of the keys
        int keysLen = keys.size();

        // Loop over all the keys
        for (int i = 0; i < keysLen; i++) {
            // If the key has been found we will return an Option with value
            if (keys.get(i) == key) return Option.some(values.get(i));
        }

        // Otherwise, we return an empty Option
        return Option.none();
    }

    // Method for returning the actual value with a default parameter passed
    @Override
    public V get(K key, V defaultValue) {
        // Same as the method above but instead returns the V type value instead of Option
        //////////////////////////////////////////////////////////////////////////////////
        // Get the length of the keys
        int keysLen = keys.size();

        // Loop over all the keys
        for (int i = 0; i < keysLen; i++) {
            // If the key has been found we will return an Option with value
            if (keys.get(i) == key) return values.get(i);
        }

        // Otherwise, we return an empty Option
        return defaultValue;
    }

    // Method for checking if the key is contained in the Dictionary
    @Override
    public boolean containsKey(K key) {
        return keys.contains(key);
    }

    // Return false if the passed key exists, otherwise return true and add the key with value
    @Override
    public boolean put(K key, V value) {
        // If the key is contained return false
        if (keys.contains(key)) return false;
        // Otherwise, add the key and value and return true
        else {
            keys.add(key);
            values.add(value);
            return true;
        }
    }

    // Same as the method above but returns false if the key doesn't exist and if it exists returns true and updates the value
    @Override
    public boolean update(K key, V value) {
        // Get the length of the keys
        int keysLen = keys.size();
        // Save the index of the kay
        int index = -1;

        // Loop over all the keys
        for (int i = 0; i < keysLen; i++) {
            // If the key has been found update the index and break
            if (keys.get(i) == key) {
                index = i;
                break;
            }
        }

        // If the index is not -1 update the value and return true
        if (index != -1) {
            values.remove(index);
            values.add(index, value);
            return true;
        }
        // Otherwise, we return false
        return false;
    }

    // Method for clearing the key and value with it
    @Override
    public void clear(K key) {
        // Same as above, only we remove both key and value
        ///////////////////////////////////////////////////
        // Get the length of the keys
        int keysLen = keys.size();
        // Save the index of the kay
        int index = -1;

        // Loop over all the keys
        for (int i = 0; i < keysLen; i++) {
            // If the key has been found update the index and break
            if (keys.get(i) == key) {
                index = i;
                break;
            }
        }

        // If the index is not -1 delete the value and key
        if (index != -1) {
            values.remove(index);
            keys.remove(index);
        }
        // Otherwise, we do nothing
    }

    // Method returns the stream of all keys
    @Override
    public Stream<K> keyStream() {
        return keys.stream();
    }

    // Method returns the stream of all values
    @Override
    public Stream<V> valueStream() {
        return values.stream();
    }

}
