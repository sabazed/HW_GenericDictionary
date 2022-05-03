package exam;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

public class SetDictionary<K, V> implements Dictionary<K, V> {

    // Create private attribute for Pair entries
    private Set<Pair<K, V>> entries;

    // Constructor for initializing entries;
    public SetDictionary() {
        this.entries = new HashSet<>();
    }

    // Method for returning an Option object
    @Override
    public Option<V> get(K key) {
        // Create an iterator for the entries
        Iterator<Pair<K, V>> entriesIterator = entries.iterator();

        // Iterate over all Pairs
        while (entriesIterator.hasNext()) {
            // Save the current pair in a temporary variable
            Pair<K, V> currentPair = entriesIterator.next();
            // If the key has been found we will return an Option with the second value from Pair
            if (currentPair.first == key) return Option.some(currentPair.second);
        }

        // Otherwise, we return an empty Option
        return Option.none();
    }

    // Method for returning the actual value with a default parameter passed
    @Override
    public V get(K key, V defaultValue) {
        // Create an iterator for the entries
        Iterator<Pair<K, V>> entriesIterator = entries.iterator();

        // Iterate over all Pairs
        while (entriesIterator.hasNext()) {
            // Save the current pair in a temporary variable
            Pair<K, V> currentPair = entriesIterator.next();
            // If the key has been found we will return the value connected to it
            if (currentPair.first == key) return currentPair.second;
        }

        // Otherwise, we return the default value provided
        return defaultValue;
    }

    // Method for checking if the key is contained in the Dictionary
    @Override
    public boolean containsKey(K key) {
        // Create an iterator for the entries
        Iterator<Pair<K, V>> entriesIterator = entries.iterator();

        // Iterate over all Pairs
        while (entriesIterator.hasNext()) {
            // Save the current pair in a temporary variable
            Pair<K, V> currentPair = entriesIterator.next();
            // If the key has been found we will return true
            if (currentPair.first == key) return true;
        }

        // Otherwise, we return false
        return false;
    }

    // Return false if the passed key exists, otherwise return true and add the key with value
    @Override
    public boolean put(K key, V value) {
        // Create an iterator for the entries
        Iterator<Pair<K, V>> entriesIterator = entries.iterator();

        // Iterate over all Pairs
        while (entriesIterator.hasNext()) {
            // Save the current pair in a temporary variable
            Pair<K, V> currentPair = entriesIterator.next();
            // If the key has been found we will return false
            if (currentPair.first == key) return false;
        }

        // Otherwise, we return true and add the Pair to the entries
        entries.add(new Pair<>(key, value));
        return true;
    }

    // Same as the method above but returns false if the key doesn't exist and if it exists returns true and updates the value
    @Override
    public boolean update(K key, V value) {
        // Create an iterator for the entries
        Iterator<Pair<K, V>> entriesIterator = entries.iterator();

        // Iterate over all Pairs
        while (entriesIterator.hasNext()) {
            // Save the current pair in a temporary variable
            Pair<K, V> currentPair = entriesIterator.next();
            // If the key has been found we will return true
            if (currentPair.first == key) {
                currentPair.second = value;
                return true;
            }
        }

        // Otherwise, we return false
        return false;
    }

    // Method for removing the Pair with the key
    @Override
    public void clear(K key) {
        // Create an iterator for the entries
        Iterator<Pair<K, V>> entriesIterator = entries.iterator();

        // Iterate over all Pairs
        while (entriesIterator.hasNext()) {
            // Save the current pair in a temporary variable
            Pair<K, V> currentPair = entriesIterator.next();
            // If the key has been found we will remove it
            if (currentPair.first == key) {
                // remove() will remove the current element from the original set
                entriesIterator.remove();
                return;
            }
        }
        // Otherwise, we do nothing
    }

    // Method returns the stream of all keys
    @Override
    public Stream<K> keyStream() {
        return entries.stream().map(entry -> entry.first);
    }

    // Method returns the stream of all values
    @Override
    public Stream<V> valueStream() {
        return entries.stream().map(entry -> entry.second);
    }

}
