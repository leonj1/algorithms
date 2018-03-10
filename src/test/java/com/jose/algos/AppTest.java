package com.jose.algos;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private CarDataStore carDataStore;

    @Before
    public void setup() {
//        Set<String> vins = new HashSet<>();
//        HashMap<String, Set> colors = new HashMap<>();
//        HashMap<String, Map> models = new HashMap<>();
//        HashMap<String, Map> makes = new HashMap<>();
//        colors.put(
//                "*",
//                vins
//        );
//        models.put(
//                "*",
//                colors
//        );
//        makes.put(
//                "*",
//                models
//        );
        this.carDataStore = new CarDataStore(
                new HashMap<String, Map<String, Map<String, Map<String, Set<String>>>>>()
        );
    }

    @Test
    public void testFib() {
        assertThat(
                App.fib8(10),
                equalTo(55L)
        );
    }

    @Test
    public void testBinarySearchFound() {
        int[] arr = {1, 21, 33, 42, 50, 66, 77, 81, 94, 101};
        assertThat(
                App.binarySearch6(arr, 21),
                equalTo(1)
        );
    }

    @Test
    public void testBinarySearchNotFound() {
        int[] arr = {1, 21, 33, 42, 50, 66, 77, 81, 94, 101};
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
        int[] arr = {0, 1, 0, 0, 1, 0};
        assertThat(
                App.seenBefore2(input, true),
                equalTo(arr)
        );
    }

    @Test
    public void isSeenAfter() {
        String input = "aabccd";
        int[] arr = {1, 0, 0, 1, 0, 0};
        assertThat(
                App.seenBefore2(input, false),
                equalTo(arr)
        );
    }

    @Test
    public void sortArrayOfVersions() {
        String[] a = new String[]{"10.2", "12.3.1", "9.8", "7.6.0", "0.0.0"};
        String[] b = new String[]{"7.6.0", "9.8", "10.2", "12.3.1", "0.0.0"};
        int[] expected = new int[]{1, 1, -1, -1, 0};
        for (int i = 0; i < a.length; i++) {
            assertThat(
                    String.format("For %s vs %s expected %s", a[i], b[i], expected[i]),
                    new Version(a[i]).compare(b[i]),
                    equalTo(expected[i])
            );
        }
    }

    @Test
    public void addCarToDataToDataStructure() {
        carDataStore.add(
                "Toyota",
                "Prius",
                "Blue",
                "1"
        );
    }

    @Test
    public void getCarVinsFromSpecificSpecsFromDataStructure() {
        carDataStore.add(
                "Toyota",
                "Prius",
                "Blue",
                "1"
        );
        assertThat(
                this.carDataStore.get(
                        "Toyota",
                        "Prius",
                        "Blue"
                ),
                equalTo(
                        new HashSet<String>() {{
                            add("1");
                        }}
                )
        );
    }

//    @Test
//    public void getCarVinsFromWildCardSpecsFromDataStructure() {
//
//    }
}
