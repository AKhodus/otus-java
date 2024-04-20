package ru.otus.java.homeworks.homework21;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayUtilsTest {
    @Test
    public void testGetSubarrayAfterLastOne() {
        assertArrayEquals(new int[]{2, 2}, ArrayUtils.getSubarrayAfterLastOne(new int[]{1, 2, 1, 2, 2}));
        assertThrows(RuntimeException.class, () -> ArrayUtils.getSubarrayAfterLastOne(new int[]{2, 2, 2, 2}));
    }

    @Test
    public void testContainsOnlyOnesAndTwos() {
        assertTrue(ArrayUtils.containsOnlyOnesAndTwos(new int[]{1, 2}));
        assertFalse(ArrayUtils.containsOnlyOnesAndTwos(new int[]{1, 1}));
        assertFalse(ArrayUtils.containsOnlyOnesAndTwos(new int[]{1, 3}));
        assertTrue(ArrayUtils.containsOnlyOnesAndTwos(new int[]{1, 2, 2, 1}));
    }
}