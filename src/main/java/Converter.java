import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator<Integer> convert(final Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> current = it.next();

            public void remove() {

            }

            public boolean hasNext() {
                if (current.hasNext()) {
                    return true;
                } else {
                    if (it.hasNext()) {
                        current = it.next();
                    }
                    return current.hasNext();
                }

            }

            public Integer next() {
                if (current.hasNext()) {
                    return current.next();
                } else {
                    if (it.hasNext()) {
                        current = it.next();
                    }
                    if (current.hasNext()) {
                        return current.next();
                    } else {
                        throw new NoSuchElementException();
                    }
                }
            }
        };
    }
}