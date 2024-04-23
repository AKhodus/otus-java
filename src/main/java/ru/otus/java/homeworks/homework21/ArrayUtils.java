package ru.otus.java.homeworks.homework21;

public class ArrayUtils {

    public static int[] getSubarrayAfterLastOne(int[] array) {
        int lastOneIndex = -1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 1) {
                lastOneIndex = i;
                break;
            }
        }

        if (lastOneIndex == -1) {
            throw new RuntimeException("Input array does not contain any ones.");
        }

        int subarrayLength = array.length - lastOneIndex - 1;
        int[] subarray = new int[subarrayLength];
        System.arraycopy(array, lastOneIndex + 1, subarray, 0, subarrayLength);
        return subarray;
    }

    public static boolean containsOnlyOnesAndTwos(int[] array) {
        for (int num : array) {
            if (num != 1 && num != 2) {
                return false;
            }
        }
        return true;
    }
}