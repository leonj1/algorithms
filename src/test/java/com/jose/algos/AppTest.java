package com.jose.algos;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testFib() {
        assertThat(
                App.fib8(10),
                equalTo(55L)
        );
    }

    @Test
    public void testBinarySearchFound() {
        int[] arr = {1,21,33,42,50,66,77,81,94,101};
        assertThat(
                App.binarySearch6(arr, 21),
                equalTo(1)
        );
    }

    @Test
    public void testBinarySearchNotFound() {
        int[] arr = {1,21,33,42,50,66,77,81,94,101};
        assertThat(
                App.binarySearch7(arr, 22),
                equalTo(-1)
        );
    }

    @Test
    public void fact1() {
        assertThat(
                App.fact(4),
                equalTo(24)
        );
    }

    @Test
    public void isSeenBefore() {
        String input = "aabccd";
        int[] arr = {0,1,0,0,1,0};
        assertThat(
                App.seenBefore2(input, true),
                equalTo(arr)
        );
    }

    @Test
    public void isSeenAfter() {
        String input = "aabccd";
        int[] arr = {1,0,0,1,0,0};
        assertThat(
                App.seenBefore2(input, false),
                equalTo(arr)
        );
    }
}
