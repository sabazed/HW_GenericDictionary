package exam;

public class Option<T> {

    // Create the private value attribute for storing data
    private T value;

    // Constructor with a parameter
    private Option(T value) {
        this.value = value;
    }

    // Constructor without parameter
    private Option() {
        this.value = null;
    }

    // Static method for creating Option object with value
    public static <T> Option<T> some(T value) {
        return new Option<T>(value);
    }

    // Static method for creating Option object without provided value
    public static <T> Option<T> none() {
        return new Option<T>();
    }

    // Getter which throws an exception if the value is null
    public T get() throws EmptyOptionException {
        if (this.value != null) return this.value;
        else throw new EmptyOptionException();
    }

    // Getter which provides default attribute which is returned if the original value is null
    public T getOrDefault(T defaultValue) {
        if (this.value != null) return this.value;
        else return defaultValue;
    }

    // Returns true if the value attribute is null, otherwise false
    public boolean isNone() {
        return this.value == null;
    }

}

// Create EmptyOptionException for getter
class EmptyOptionException extends Exception {
    public EmptyOptionException() {
        super();
    }
}