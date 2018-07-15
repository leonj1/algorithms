package com.jose.algos;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private CarDataStore carDataStore;
    private CommonTreeNode commonTreeNode;

    @Before
    public void setup() {
        this.carDataStore = new CarDataStore(
                new HashMap<String, Map<String, Map<String, Map<String, Set<String>>>>>()
        );
        this.commonTreeNode = new CommonTreeNode(
                new Node(
                        0,
                        new Node(
                                1,
                                new Node(
                                        3,
                                        new Node(5, null, null),
                                        new Node(6, null, null)
                                ),
                                new Node(
                                        4,
                                        new Node(7, null, null),
                                        new Node(8, null, null)
                                )
                        ),
                        new Node(
                                2,
                                new Node(
                                        31,
                                        new Node(10, null, null),
                                        new Node(20, null, null)
                                ),
                                new Node(
                                        40,
                                        new Node(
                                                19,
                                                new Node(
                                                        120,
                                                        null,
                                                        null
                                                ),
                                                null
                                        ),
                                        null
                                )
                        )
                )
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
        carDataStore.add(
                "Toyota",
                "Highlander",
                "Brown",
                "2"
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

    @Test
    public void getCarVinsFromWildCardSpecsFromDataStructure() {
        carDataStore.add(
                "Toyota",
                "Prius",
                "Blue",
                "1"
        );
        assertThat(
                this.carDataStore.get(
                        "Toyota",
                        "*",
                        "Blue"
                ),
                equalTo(
                        new HashSet<String>() {{
                            add("1");
                        }}
                )
        );
    }

    @Test
    public void findTheSameImmediateParentNode() {
        assertThat(
                this.commonTreeNode.findCommonNode(31, 40).value(),
                equalTo(2)
        );
    }

    @Test
    public void findTheSameDistantParentNode() {
        assertThat(
                this.commonTreeNode.findCommonNode(31, 120).value(),
                equalTo(2)
        );
    }

    @Test
    public void findSameParentNodeWhenTargetNodesAreChained() {
        assertThat(
                this.commonTreeNode.findCommonNode(19, 120).value(),
                equalTo(40)
        );
    }

    @Ignore
    @Test
    public void getTopTenSongs() {
        TopTenSongs topTenSongs = new TopTenSongs(
                new PriorityQueue<String>(),
                new HashMap<String, Integer>()
        );
        topTenSongs.add("1");
        topTenSongs.add("2");
        topTenSongs.add("3");
        topTenSongs.add("4");
        topTenSongs.add("5");
        topTenSongs.add("6");
        topTenSongs.add("7");
        topTenSongs.add("8");
        topTenSongs.add("9");
        topTenSongs.add("10");
        topTenSongs.add("11");
        topTenSongs.add("12");
        topTenSongs.add("13");
        topTenSongs.add("1");
        topTenSongs.add("2");
        assertThat(
                topTenSongs.topTen(),
                Matchers.<List<String>>equalTo(
                        new ArrayList<String>() {{
                            add("1");
                            add("2");
                            add("3");
                            add("4");
                            add("5");
                            add("6");
                            add("7");
                            add("8");
                            add("9");
                            add("10");
                        }}
                )
        );
    }

    @Test
    public void permutationsUsingString() {
        // Using String is expected to be easier since Strings are immutable
        List<String> results = new ArrayList<>();
        permutations("", "abc", results);
        assertThat(
                results,
                Matchers.<List<String>>equalTo(
                        new ArrayList<String>() {{
                            add("abc");
                            add("acb");
                            add("bac");
                            add("bca");
                            add("cab");
                            add("cba");
                        }}
                )
        );
    }

    @Test
    public void permutationsUsingArray() {
        List<int[]> results = new ArrayList<>();
        arrPermutations(new int[]{1,2,3}, 0, results);
        assertThat(results.size(), equalTo(6));
        assertThat(results.get(0), equalTo(new int[]{1,2,3}));
        assertThat(results.get(1), equalTo(new int[]{1,3,2}));
        assertThat(results.get(2), equalTo(new int[]{2,1,3}));
        assertThat(results.get(3), equalTo(new int[]{2,3,1}));
        assertThat(results.get(4), equalTo(new int[]{3,2,1}));
        assertThat(results.get(5), equalTo(new int[]{3,1,2}));
    }

    /**
     * Permutation using String (easy)
     * Prefix is initially empty string, but the goal is to slowly move the chars from suffix to prefix 1 char at a time
     * Once suffix is empty add that to list.
     * The "i" in for loop is a pointer which tracks which char to swap out
     */
    private void permutations(String prefix, String suffix, List<String> result) {
        if("".equals(suffix)) {
            result.add(prefix + suffix);
        }
        for(int i = 0; i < suffix.length(); i++) {
            permutations(
                    prefix + Character.toString(suffix.charAt(i)),
                    suffix.substring(0,i) + suffix.substring(i+1,suffix.length()),
                    result
            );
        }
    }

    private void arrPermutations(int[] a, int start, List<int[]> list) {
        if(start >= a.length) {
            list.add(a.clone());
        }
        for(int i=start; i<a.length; i++) {
            swap(a, start, i);
            arrPermutations(
                    a,
                    start + 1,
                    list
            );
            swap(a, start, i);
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
