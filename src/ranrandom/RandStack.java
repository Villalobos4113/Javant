package ranrandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

/**
 * @author Fernando Villalobos Betancourt
 *
 */

public class RandStack<T> {

    // Attributes

    private final ArrayList<T> arrayList;

    // Constructors

    public RandStack(T[] array, int noElements) {
        this.arrayList = new ArrayList<>();

        arrayList.addAll(Arrays.asList(array).subList(0, noElements));
    }

    public RandStack(Iterable<T> iterable) {
        this.arrayList = new ArrayList<>();

        for (T data: iterable)
            this.arrayList.add(data);
    }

    @SafeVarargs
    public RandStack(T... values) {
        this.arrayList = new ArrayList<>();

        Collections.addAll(arrayList, values);
    }

    // Equals & Hash Code

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandStack<?> that = (RandStack<?>) o;
        return arrayList.equals(that.arrayList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arrayList);
    }

    // Class Methods

    public T pop() {
        if (!arrayList.isEmpty())
            return arrayList.remove((int) (Math.random() * arrayList.size()));
        else
            return null;
    }

    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    public int size(){ return arrayList.size(); }

    public Class getStoredClass() {
        if (!arrayList.isEmpty())
            return arrayList.get(0).getClass();
        else
            return null;
    }
}