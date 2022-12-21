package ranrandom;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author Fernando Villalobos Betancourt
 *
 */

public class Ranrandom {


    // ===== RANDOM =====

    // Random [0, n)

    public static double random(double top) { return Math.random() * top; }

    public static int randInt(int top) {
        return (int) (Math.random() * top);
    }

    // Random [n, m)

    public static double random(double min, double max) { return (Math.random()*(max - min)) + min; }

    public static int randInt(int min, double max) {
        return (int) (Math.random()*(max - min)) + min;
    }


    // ===== CHOICE =====

    public static <T> T choice(T[] array, int noElements) {
        return array[(int) (Math.random() * noElements)];
    }

    public static <T> T choice(Iterable<T> iterable) { RandStack<T> randStack = new RandStack<>(iterable); return randStack.pop(); }

    @SafeVarargs
    public static <T> T choice(T... values) { return values[(int) (Math.random() * values.length)]; }


    // ===== CHOICES =====

    // Random Length

    public static <T> T[] choices(T[] array, int noElements) {
        if (noElements >= 2) {
            RandStack<T> randStack = new RandStack<>(array, noElements);
            T[] auxArray = (T[]) Array.newInstance(randStack.getStoredClass(), (int) (Math.random() * (noElements - 1)) + 1);

            for (int i = 0; i < auxArray.length; i++)
                auxArray[i] = randStack.pop();

            return auxArray;
        } else
            return null;
    }

    public static <T> T[] choices(Iterable<T> iterable) {
        RandStack<T> randStack = new RandStack<>(iterable);

        if (randStack.size() >= 2) {
            T[] auxArray = (T[]) Array.newInstance(randStack.getStoredClass(), (int) (Math.random() * (randStack.size() - 1)) + 1);

            for (int i = 0; i < auxArray.length; i++)
                auxArray[i] = randStack.pop();

            return auxArray;
        } else
            return null;
    }

    @SafeVarargs
    public static <T> T[] choices(T... values) {
        if (values.length >= 2) {
            RandStack<T> randStack = new RandStack<>(values);
            T[] auxArray = (T[]) Array.newInstance(randStack.getStoredClass(), (int) (Math.random() * (values.length - 1)) + 1);

            for (int i = 0; i < auxArray.length; i++)
                auxArray[i] = randStack.pop();

            return auxArray;
        } else
            return null;
    }

    // Given Length

    public static <T> T[] choices(int length, T[] array, int noElements) {
        if (noElements >= 2 && length < noElements) {
            RandStack<T> randStack = new RandStack<>(array, noElements);
            T[] auxArray = (T[]) Array.newInstance(randStack.getStoredClass(), length);

            for (int i = 0; i < auxArray.length; i++)
                auxArray[i] = randStack.pop();

            return auxArray;
        } else
            return null;
    }

    public static <T> T[] choices(int length, Iterable<T> iterable) {
        RandStack<T> randStack = new RandStack<>(iterable);

        if (randStack.size() >= 2 && length < randStack.size()) {
            T[] auxArray = (T[]) Array.newInstance(randStack.getStoredClass(), length);

            for (int i = 0; i < auxArray.length; i++)
                auxArray[i] = randStack.pop();

            return auxArray;
        } else
            return null;
    }

    @SafeVarargs
    public static <T> T[] choicesLength(int length, T... values) {
        if (values.length >= 2) {
            RandStack<T> randStack = new RandStack<>(values);
            T[] auxArray = (T[]) Array.newInstance(randStack.getStoredClass(), length);

            for (int i = 0; i < auxArray.length; i++)
                auxArray[i] = randStack.pop();

            return auxArray;
        } else
            return null;
    }


    // ===== SHUFFLE =====

    public static <T> void shuffle(T[] array, int noElementos) {
        RandStack<T> randStack = new RandStack<>(array, noElementos);

        for (int i = 0; i < noElementos; i++)
            array[i] = randStack.pop();
    }

    public static <T> void shuffle(ArrayList<T> arrayList) {
        RandStack<T> randStack = new RandStack<>(arrayList);

        for (int i = 0; i < arrayList.size(); i++)
            arrayList.set(i, randStack.pop());
    }
}