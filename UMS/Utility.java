import java.util.Arrays;

public class Utility {
    public static <T> boolean linearSearch(T[] array, T key) {
        for (T item : array) {
            if (item.equals(key)) return true;
        }
        return false;
    }
}
