/*----------------------------------------------------------------------
	FILE        : ArrayUtil.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 19.10.2023

	Utility class for array operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.array;

import java.util.Comparator;
import java.util.random.RandomGenerator;

public final class ArrayUtil {
    private static void bubbleSortAscending(int [] a)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k] > a[k + 1])
                    swap(a, k, k + 1);
    }

    private static void bubbleSortDescending(int [] a)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k] < a[k + 1])
                    swap(a, k, k + 1);
    }

    private static void bubbleSortAscending(double [] a)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k] > a[k + 1])
                    swap(a, k, k + 1);
    }

    private static void bubbleSortDescending(double [] a)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k] < a[k + 1])
                    swap(a, k, k + 1);
    }

    private static void bubbleSortAscending(long [] a)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k] > a[k + 1])
                    swap(a, k, k + 1);
    }

    private static void bubbleSortDescending(long [] a)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k] < a[k + 1])
                    swap(a, k, k + 1);
    }

    private static <T> void bubbleSortAscending(T [] a, Comparator<? super T> comparator)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (comparator.compare(a[k + 1], a[k]) > 0)
                    swap(a, k, k + 1);
    }

    private static <T> void bubbleSortDescending(T [] a, Comparator<? super T> comparator)
    {
        bubbleSortAscending(a, comparator.reversed());
    }

    private static void bubbleSortAscending(Object [] a)
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private static void selectionSortAscending(int [] a)
    {
        for (int i = 0; i < a.length - 1; ++i) {
            int min = a[i];
            int minIndex = i;

            for (int k = i + 1; k < a.length; ++k)
                if (a[k] < min) {
                    min = a[k];
                    minIndex = k;
                }
            a[minIndex] = a[i];
            a[i] = min;
        }
    }

    private static void selectionSortDescending(int [] a)
    {
        for (int i = 0; i < a.length - 1; ++i) {
            int max = a[i];
            int maxIndex = i;

            for (int k = i + 1; k < a.length; ++k)
                if (a[k] > max) {
                    max = a[k];
                    maxIndex = k;
                }
            a[maxIndex] = a[i];
            a[i] = max;
        }
    }

    private ArrayUtil()
    {
    }

    public static void addBy(int [] a, int val)
    {
        for (int i = 0; i < a.length; ++i)
            a[i] += val;
    }

    public double average(int [] a)
    {
        return sum(a) / (double)a.length;
    }

    public static void bubbleSort(int [] a)
    {
        bubbleSortAscending(a);
    }

    public static void bubbleSort(int [] a, boolean desc)
    {
        if (desc)
            bubbleSortDescending(a);
        else
            bubbleSortAscending(a);
    }

    public static <T> void bubbleSort(T [] a, Comparator<? super T> comparator)
    {
        bubbleSortAscending(a, comparator);
    }

    public static <T> void bubbleSort(T [] a, Comparator<? super T> comparator, boolean desc)
    {
        if (desc)
            bubbleSortDescending(a, comparator);
        else
            bubbleSortAscending(a, comparator);
    }

    public static void display(int n, int...values)
    {
        String fmt = String.format("%%0%dd ", n);

        for (int val : values)
            System.out.printf(fmt, val);

        System.out.println();
    }

    public static void display(int...values)
    {
        display(1, values);
    }

    public static void display(double...values)
    {
        for (double val : values)
            System.out.printf("%f", val);

        System.out.println();
    }

    public static void display(int n, int [][] a)
    {
        for (int [] array : a)
            display(n, array);
    }

    public static void display(String...str)
    {
        for (String s : str)
            System.out.println(s);
    }

    public static void display(byte...b)
    {
        display(b.length, b);
    }

    public static void display(int length, byte...b)
    {
        display(length, ' ', '\n', b);
    }

    public static void display(int length, char sep, char end, byte...b)
    {
        for (int i = 0; i < length; ++i)
            System.out.printf("%d%c", b[i], sep);

        System.out.print(end);
    }

    public static void fillRandomArray(RandomGenerator randomGenerator, int [] a, int min, int max)
    {
        for (int i = 0; i < a.length; ++i)
            a[i] = randomGenerator.nextInt(max - min + 1) + min;
    }

    public static int [] getHistogramData(int [] a, int n) //[0, n]
    {
        int [] counts = new int[n + 1];

        for (int val : a)
            ++counts[val];

        return counts;
    }

    public static int [] getRandomArray(RandomGenerator randomGenerator, int n, int min, int max) //[min, max]
    {
        int [] a = new int[n];

        fillRandomArray(randomGenerator, a, min, max);

        return a;
    }

    public static int max(int [] a)
    {
        int maxVal = a[0];

        for (int i = 1; i < a.length; ++i)
            maxVal = Math.max(maxVal, a[i]);

        return maxVal;
    }

    public static int min(int [] a)
    {
        int minVal = a[0];

        for (int i = 1; i < a.length; ++i)
            minVal = Math.min(minVal, a[i]);

        return minVal;
    }

    public static int partition(int [] a, int threshold)
    {
        int partitionIndex = 0;

        while (partitionIndex != a.length && a[partitionIndex] < threshold)
            ++partitionIndex;

        if (partitionIndex == a.length)
            return partitionIndex;

        for (int i = partitionIndex + 1; i < a.length; ++i)
            if (a[i] < threshold)
                swap(a, i, partitionIndex++);

        return partitionIndex;
    }

    public static void reverse(int [] a)
    {
        int halfLen = a.length / 2;

        for (int i = 0; i < halfLen; ++i)
            swap(a, i, a.length - 1 - i);
    }

    public static void reverse(char [] c)
    {
        int halfLen = c.length / 2;

        for (int i = 0; i < halfLen; ++i)
            swap(c, i, c.length - 1 - i);
    }

    public static int [] reversed(int [] a)
    {
        int [] r = new int[a.length];

        for (int i = a.length - 1; i >= 0; --i)
            r[a.length - 1 - i] = a[i];

        return r;
    }

    public static void selectionSort(int [] a)
    {
        selectionSortAscending(a);
    }

    public static void selectionSort(int [] a, boolean desc)
    {
        if (desc)
            selectionSortDescending(a);
        else
            selectionSortAscending(a);
    }

    public static void shuffle(RandomGenerator randomGenerator, int [] a, int count)
    {
        while (count-- > 0)
            swap(a, randomGenerator.nextInt(a.length), randomGenerator.nextInt(a.length));
    }

    public static int sum(int [] a)
    {
        var total = 0;

        for (var val : a)
            total += val;

        return total;
    }

    public static double sum(double [] a)
    {
        var total = 0.;

        for (var val : a)
            total += val;

        return total;
    }

    public static int sum(int [][] a)
    {
        int total = 0;

        for (int [] array : a)
            total += sum(array);

        return total;
    }

    public static int sumDiagonal(int [][] a)
    {
        int total = 0;

        for (int i = 0; i < a.length; ++i)
            total += a[i][i];

        return total;
    }

    public static void swap(int [] a, int i, int k)
    {
        var temp = a[i];

        a[i] = a[k];
        a[k] = temp;
    }

    public static void swap(double [] a, int i, int k)
    {
        var temp = a[i];

        a[i] = a[k];
        a[k] = temp;
    }

    public static void swap(long [] a, int i, int k)
    {
        var temp = a[i];

        a[i] = a[k];
        a[k] = temp;
    }

    public static <T> void swap(T [] a, int i, int k)
    {
        var temp = a[i];

        a[i] = a[k];
        a[k] = temp;
    }

    public static void swap(char [] c, int i, int k)
    {
        var temp = c[i];

        c[i] = c[k];
        c[k] = temp;
    }
}
