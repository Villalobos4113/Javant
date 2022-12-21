package binarray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Fernando Villalobos Betancourt
 *
 */

public class Binarray {

    // === TO STRING ===

    public static <T> String toString(T[] array, int noElements) {
        StringBuilder sb = new StringBuilder();

        if (noElements != 0) {
            sb.append("[");

            for (int i = 0; i < noElements - 1; i++)
                sb.append(array[i]).append(", ");

            sb.append(array[noElements - 1]).append("]");
        } else
            sb.append("[]");

        return sb.toString();
    }

    public static <T> String toString(T[] array) {
        StringBuilder sb = new StringBuilder();

        if (array.length != 0) {
            sb.append("[");

            for (int i = 0; i < array.length - 1; i++)
                sb.append(array[i]).append(", ");

            sb.append(array[array.length - 1]).append("]");
        } else
            sb.append("[]");

        return sb.toString();
    }


    // === INSERT & DELETE ===

    public static <T> boolean insert(T data, T[] array, int noElements, int index) {
        boolean res = false;

        if (array.length > noElements && index < array.length && index >= 0) {
            if (traverseRight(array, noElements, index)) {
                array[index] = data;
                res = true;
            }
        }

        return res;
    }

    public static <T> T delete(T[] array, int noElements, int index) {
        T res = null;

        if (index >= 0 && index < noElements) {
            res = array[index];
            traverseLeft(array, noElements, index);
        }

        return res;
    }


    // === MAX & MIN ===

    // Max

    private static <T extends Comparable<T>> int max(T[] array, int noElements) {
        if (noElements > 0) {
            int res = 0;

            for (int i = 1; i < noElements; i++) {
                if (array[i].compareTo(array[res]) > 0)
                    res = i;
            }

            return res;
        } else
            return -1;
    }

    private static <T  extends Comparable<T>> int max(T[] array, int noElements, int indexStart) {
        if (noElements > 0 && indexStart < noElements) {
            int res = indexStart;

            for (int i = indexStart + 1; i < noElements; i++) {
                if (array[i].compareTo(array[res]) > 0)
                    res = i;
            }

            return res;
        } else
            return -1;
    }

    // Min

    private static <T extends Comparable<T>> int min(T[] array, int noElements) {
        if (noElements > 0) {
            int res = 0;

            for (int i = 1; i < noElements; i++) {
                if (array[i].compareTo(array[res]) < 0)
                    res = i;
            }

            return res;
        } else
            return -1;
    }

    private static <T extends Comparable<T>> int min(T[] array, int noElements, int indexStart) {
        if (noElements > 0 && indexStart < noElements) {
            int res = indexStart;

            for (int i = indexStart + 1; i < noElements; i++) {
                if (array[i].compareTo(array[res]) < 0)
                    res = i;
            }

            return res;
        } else
            return -1;
    }


    // === MOVE ELEMENTS ===

    public static <T> boolean traverseLeft(T[] array, int noElements, int index) {
        if (index < noElements - 1 && index >= 0) {
            if (noElements - (index + 1) >= 0)
                System.arraycopy(array, index + 1, array, index + 1 - 1, noElements - (index + 1));

            array[noElements - 1] = null;
            return true;
        } else
            return false;
    }

    public static <T> boolean traverseRight(T[] array, int noElements, int index) {
        if (array.length > noElements && index < noElements && index >= 0) {
            System.arraycopy(array, index, array, index + 1, noElements - index);

            array[index] = null;
            return true;
        } else
            return false;
    }


    // === REVERSE ===

    public static <T> void reverse(T[] array, int noElements) {
        if (noElements > 1) {
            int i = 0;
            T aux;

            while (i < noElements - 1) {
                aux = array[i];
                array[i] = array[noElements - 1];
                array[noElements - 1] = aux;
                noElements--;
                i++;
            }
        }
    }

    public static <T> void reverse(T[] array) {
        if (array.length > 1) {
            int i = 0, noElements = array.length;
            T aux;

            while (i < noElements - 1) {
                aux = array[i];
                array[i] = array[noElements - 1];
                array[noElements - 1] = aux;
                noElements--;
                i++;
            }
        }
    }


    // === CLEAR ===

    public static <T> void clear(T[] array, int noElements) {
        for (int i = 0; i < noElements; i++)
            array[i] = null;
    }

    public static <T> void clear(T[] array) {
        Arrays.fill(array, null);
    }


    // === EXTEND ===

    public static <T> T[] extend(T[] arrayA, int noElementsA, T[] arrayB, int noElementsB) {
        T[] res = (T[]) Array.newInstance(arrayA[0].getClass(), noElementsA + noElementsB);

        if (noElementsA >= 0)
            System.arraycopy(arrayA, 0, res, 0, noElementsA);

        if (noElementsB >= 0)
            System.arraycopy(arrayB, 0, res, noElementsA, noElementsB);

        return res;
    }

    @SafeVarargs
    public static <T> T[] extend(T[]... arrays) {
        ArrayList<T> res = new ArrayList<>();

        for (T[] array : arrays) {
            Collections.addAll(res, array);
        }

        return res.toArray((T[]) Array.newInstance(res.get(0).getClass(), res.size()));
    }

    public static <T> T[] extend(T[] arrayA, int noElementsA, Iterable<T> iterable) {

        ArrayList<T> res = new ArrayList<>(Arrays.asList(arrayA).subList(0, noElementsA));

        for (T data : iterable)
            res.add(data);

        return res.toArray((T[]) Array.newInstance(res.get(0).getClass(), res.size()));

    }

    public static <T> T[] extend(T[] arrayA, Iterable<T> iterable) {
        ArrayList<T> res = new ArrayList<>();

        Collections.addAll(res, arrayA);

        for (T data : iterable)
            res.add(data);

        return res.toArray((T[]) Array.newInstance(res.get(0).getClass(), res.size()));

    }


    // === EXPAND ===

    public static <T> T[] expand(T[] array) {
        T[] resArray = (T[]) Array.newInstance(array[0].getClass(), array.length * 2);

        System.arraycopy(array, 0, resArray, 0, array.length);

        return resArray;
    }

    public static <T> T[] expand(T[] array, int expand) {
        T[] resArray = (T[]) Array.newInstance(array[0].getClass(), expand + array.length);

        System.arraycopy(array, 0, resArray, 0, array.length);

        return resArray;
    }


    // === SEARCH ===

    // Sequential Search

    public static <T> int search(T data, T[] array, int noElementos) {
        int res = -1, i = 0, j = noElementos - 1;

        while (res == -1 && i <= j) {
            if (array[i].equals(data))
                res = i;
            else if (array[j].equals(data))
                res = j;
            i++;
            j--;
        }

        return res;
    }

    // Binary Search

    public static <T extends Comparable<T>> int binarySearch(T data, T[] array, int noElementos) {
        return binarySearch(data, array, noElementos, 0);
    }

    private static <T extends Comparable<T>> int binarySearch(T data, T[] array,  int top, int bottom) {
        if (top < bottom)
            return -(bottom + 1);
        else {
            int middle = (top + bottom) / 2;

            if (array[middle].equals(data))
                return middle;

            else if (array[middle].compareTo(data) < 0)
                return binarySearch(data, array, top, middle + 1);

            else
                return binarySearch(data, array, middle - 1, bottom);
        }
    }


    // === SORT ===

    public static <T extends Comparable<T>> void sort(T[] array, int noElementos) {
        for (int i = 0; i < noElementos; i++) {
            int posMin = min(array, noElementos, i);
            T min = array[posMin];
            array[posMin] = array[i];
            array[i] = min;
        }
    }

    // === JOIN ===

    public static <T> String join(T[] array) {
        StringBuilder sb = new StringBuilder();

        for (T data : array)
            sb.append(data);

        return sb.toString();
    }

    public static <T> String join(T[] array, int noElementos) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < noElementos; i++)
            sb.append(array[i]);

        return sb.toString();
    }

    public static <T> String join(T[] array, char regex) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length - 1; i++) {
            sb.append(array[i]).append(regex);
        }

        sb.append(array[array.length - 1]);

        return sb.toString();
    }

    public static <T> String join(T[] array, int noElementos, char regex) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < noElementos - 1; i++) {
            sb.append(array[i]).append(regex);
        }

        sb.append(array[noElementos - 1]);

        return sb.toString();
    }

    public static <T> String join(T[] array, String regex) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length - 1; i++) {
            sb.append(array[i]).append(regex);
        }

        sb.append(array[array.length - 1]);

        return sb.toString();
    }

    public static <T> String join(T[] array, int noElementos, String regex) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < noElementos - 1; i++) {
            sb.append(array[i]).append(regex);
        }

        sb.append(array[noElementos - 1]);

        return sb.toString();
    }
}