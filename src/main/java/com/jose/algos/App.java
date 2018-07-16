package com.jose.algos;

import com.jose.algos.validations.HalfPlusSevenValidation;
import com.jose.algos.validations.RecipientCannotBeOlderThanSender;
import com.jose.algos.validations.SenderCannotFriendAnotherUnder100YearsOld;
import com.jose.algos.validations.Validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        long result = fib4(10);
        System.out.println(String.format("Result is: %d", result));

        int[] arr = {1, 21, 33, 42, 50, 66, 77, 81, 94, 101};
        System.out.println(String.format("Bin Search result is %d", binarySearch3(arr, 21)));

        // setup validation chains
        Validation validation = new HalfPlusSevenValidation(
                new RecipientCannotBeOlderThanSender(
                        new SenderCannotFriendAnotherUnder100YearsOld(null)
                )
        );

//        int numOfRequest = count_all_friend_requests([120, 45, 55, 230, 400, 88, 300, 101], validation);

        // pay off largest to smallest


        // pay off smallest to largest

    }

    private static int count_all_friend_requests(int[] arr, Validation validation) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 1; j < arr.length - 1; j++) {
                if (validation.check(i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static long fib(long i) {
        if (i == 0 || i == 1) {
            return i;
        }
        return fib(i - 1) + fib(i - 2);
    }

    public static long fib2(long i) {
        if (i < 2) {
            return i;
        }
        return fib2(i - 1) + fib2(i - 2);
    }

    public static long fib3(long i) {
        if (i < 2) {
            return i;
        }

        return fib3(i - 1) + fib3(i - 2);
    }

    public static long fib4(long i) {
        if (i < 2) {
            return i;
        }
        return fib4(i - 1) + fib4(i - 2);
    }

    public static long fib5(long i) {
        if (i < 2) {
            return i;
        }

        return fib(i - 1) + fib(i - 2);
    }

    public static long fib6(long i) {
        if (i < 2) {
            return i;
        }
        return fib6(i - 1) + fib6(i - 2);
    }

    public static long fib7(long i) {
        if (i < 2) {
            return i;
        }
        return fib(i - 1) + fib(i - 2);
    }

    public static long fib8(long i) {
        if (i < 2) {
            return 1;
        }
        return fib(i - 1) + fib(i - 2);
    }

    public static int binarySearch(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (key == arr[mid]) {
                return mid;
            }
            if (key < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static int binarySearch2(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key == arr[mid]) {
                return mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch3(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key == arr[mid]) {
                return mid;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static int binarySearch4(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key <= arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch5(int[] arr, int key) {
        int start = 0;
        int end = (start + arr.length) - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch6(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch7(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key <= arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    //  Given a sorted array and a number x, find the pair in array whose sum is closest to x
//    public static int[] findPair(int[] arr, int x) {
//        int pair =
//    }
////    public static int[] binSortArray(int[] arr) {
////        if(arr.length<2) {
////            return arr;
////        }
////        int pivot = arr[arr.length-1];
////        return
////    }

    public static int fact(int n) {
        int result;
        if (n == 0 || n == 1) {
            return 1;
        }

        result = fact(n - 1) * n;
        return result;
    }

    public static int[] seenBefore(String input, boolean seenBefore) {
        String[] arr = input.split("");
        Map<String, Integer> positions = new HashMap<String, Integer>();
        int i = 0;
        if (seenBefore) {
            for (String c : arr) {
                if (positions.get(c) == null) {
                    positions.put(c, i);
                }
                i++;
            }
        } else {
            for (String c : arr) {
                positions.put(c, i);
                i++;
            }
        }

        List<Integer> results = new ArrayList<Integer>();
        i = 0;
        for (String c : arr) {
            if (seenBefore) {
                if (positions.get(c) != null && positions.get(c) < i) {
                    results.add(1);
                } else {
                    results.add(0);
                }
            } else {
                if (positions.get(c) != null && positions.get(c) > i) {
                    results.add(1);
                } else {
                    results.add(0);
                }
            }
            i++;
        }

        return results.stream().mapToInt(n -> n).toArray();
    }

    public static int[] seenBefore2(String input, boolean seenBefore) {
        if (seenBefore) {
            return new SeenBefore(input).results();
        } else {
            return new SeenAfter(input).results();
        }
    }

    // implement buy and download button of an App

    // Get the top 10 songs played in the last 24 hours

}

class Minute {
    private final ConcurrentHashMap<SongTwo, AtomicLong> map = new ConcurrentHashMap<>();
    private final PriorityQueue<SongTwo> topTen;
    private String name;
    private int size;

    Minute(String name) {
        this.name = name;
        this.size = 10;
        this.topTen = new PriorityQueue<SongTwo>(size, new Comparator<SongTwo>() {
            @Override
            public int compare(SongTwo o1, SongTwo o2) {
                return o1.count() - o2.count();
            }
        });
    }

    public synchronized void add(String name) {
        SongTwo song = new SongTwo(name);
        this.map.putIfAbsent(song, new AtomicLong(0));
        long numTimesPlayed = this.map.get(song).incrementAndGet();
        if(this.topTen.size() < this.size) {
            this.topTen.add(song);
        } else {
            if (this.size == this.topTen.size()) {
                this.topTen.poll();
            }
            this.topTen.add(song);
        }
    }

    public synchronized SongTwo[] topTen() {
        SongTwo[] songs = this.topTen.toArray(new SongTwo[this.topTen.size()]);
        Arrays.sort(songs, this.topTen.comparator());
        return songs;
    }

    public String name() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Minute minute = (Minute) o;
        return Objects.equals(name, minute.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Minute{" +
            "map=" + map +
            ", topTen=" + topTen +
            ", name='" + name + '\'' +
            ", size=" + size +
            '}';
    }
}

class SongTwo {
    private String name;
    private int count;

    SongTwo(String name) {
        this.name = name;
        this.count = 1;
    }

    public void increment() {
        this.count++;
    }

    public String name() {
        return this.name;
    }

    public int count() {
        return this.count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongTwo songTwo = (SongTwo) o;
        return Objects.equals(name, songTwo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "SongTwo{" +
            "name='" + name + '\'' +
            ", count=" + count +
            '}';
    }
}

class Song implements Comparable<Song> {
    private String name;
    private Integer count;

    public Song(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(name, song.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Song o) {
        if(o.getCount() > this.count) {
            return 1;
        } else if(o.getCount() < this.count) {
            return -1;
        }
        return 0;
    }
}

//class TopTenSongs {
//    private PriorityQueue<String> queue;
//    private Map<String, Integer> songs;
//    private List<String> songs;
//
//    public TopTenSongs(PriorityQueue<String> queue, Map<String, Integer> songs) {
//        this.queue = queue;
//        this.songs = songs;
//    }
//
//    public void add(String song) {
//        Integer count = this.songs.get(song);
//        if(count == null) {
//            this.songs.put(song, 1);
//            return;
//        }
//        count++;
//        this.songs.put(song, count);
//    }
//
//    public List<String> topTen() {
//        return null;
//    }
//}

class Node {
    private int value;
    private Node left;
    private Node right;

    Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int value() {
        return value;
    }

    public Node left() {
        return left;
    }

    public Node right() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

// find the common node of two integers (a,b) in a tree
class CommonTreeNode {

    private Node root;
    private Stack<Node> aStack;
    private Stack<Node> bStack;

    CommonTreeNode(Node root) {
        this.root = root;
        this.aStack = new Stack<Node>();
        this.bStack = new Stack<Node>();
    }

    public Node findCommonNode(int a, int b) {
        // find a
        this.aStack.clear();
        boolean aFound = find(this.root, a, this.aStack);
        if (!aFound) {
            return null;
        }
        boolean bFound = find(this.root, b, this.bStack);
        if (!bFound) {
            return null;
        }
        List<Node> intersect = bStack
                .stream()
                .collect(Collectors.toList())
                .stream()
                .filter(aStack
                        .stream()
                        .collect(Collectors.toList())
                        ::contains
                ).collect(Collectors.toList());
        if (intersect.size() == 0) {
            return null;
        }
        return intersect.get(intersect.size()-1);
    }

    private boolean find(Node topNode, int val, Stack stack) {
        if (topNode == null) {
            return false;
        }
        if (topNode.value() == val) {
            return true;
        }

        stack.push(topNode);
        if (topNode.left() != null) {
            if (find(topNode.left(), val, stack)) {
                return true;
            }
        }
        if(topNode.right() == null) {
            stack.pop();
            return false;
        }

        if (find(topNode.right(), val, stack)) {
            return true;
        }
        stack.pop();
        return false;
    }
}

class CarDataStore {
    private Map<String, Map<String, Map<String, Map<String, Set<String>>>>> store;

    public CarDataStore(Map<String, Map<String, Map<String, Map<String, Set<String>>>>> store) {
        this.store = store;
    }

    public void add(String make, String model, String color, String vin) {
        foo(make, model, color, vin);
        foo("*", model, color, vin);
        foo(make, "*", color, vin);
        foo(make, model, "*", vin);
        foo("*", "*", color, vin);
        foo(make, "*", "*", vin);
        foo("*", model, "*", vin);
        foo("*", "*", "*", vin);
    }

    private void foo(String make, String model, String color, String vin) {
        Map<String, Map<String, Map<String, Set<String>>>> makes = this.store.get(make);
        if (makes == null) {
            makes = new HashMap<String, Map<String, Map<String, Set<String>>>>() {{
                put(
                        make,
                        new HashMap<String, Map<String, Set<String>>>()
                );
            }};
        }
        Map<String, Map<String, Set<String>>> models = makes.get(model);
        if (models == null) {
            models = new HashMap<String, Map<String, Set<String>>>() {{
                put(
                        model,
                        new HashMap<String, Set<String>>()
                );
            }};
        }
        Map<String, Set<String>> colors = models.get(color);
        if (colors == null) {
            colors = new HashMap<String, Set<String>>() {{
                put(
                        color,
                        new HashSet<String>() {{ add(vin); }}
                );
            }};
        } else {
            Set<String> vins = colors.get(color);
            if (vins == null) {
                vins = new HashSet<String>();
            }
            vins.add(vin);
            colors.put(color, vins);
        }
        models.put(color, colors);
        makes.put(model, models);
        this.store.put(make, makes);
    }

    public Set<String> get(String make, String model, String color) {
        Map<String, Map<String, Map<String, Set<String>>>> makes = this.store.get(make);
        Map<String, Map<String, Set<String>>> models = makes.get(model);
        Map<String, Set<String>> colors = models.get(color);
        Set<String> vins = colors.get(color);
        return vins;
    }
}

// determine if one version is larger than another
// TODO compare without using objects
// TODO compare using objects
class Version {
    private String input;

    Version(String input) {
        this.input = input;
    }

    public int compare(String o) {
        String[] a = this.input.split("\\.");
        String[] b = o.split("\\.");
        for(int i = 0; (i < a.length && i < b.length); i++) {
            if (Integer.valueOf(a[i]) < Integer.valueOf(b[i])) {
                return -1;
            } else if (Integer.valueOf(a[i]) > Integer.valueOf(b[i])) {
                return 1;
            }
        }
        if (a.length < b.length) {
            return -1;
        }
        return 0;
    }
}

class SeenBefore {
    private String input;

    SeenBefore(String input) {
        this.input = input;
    }

    public int[] results() {
        List<Integer> results = new ArrayList<>();
        Map<String, Integer> history = new HashMap<String, Integer>();
        int i = 0;
        for (String c : this.input.split("")) {
            if (history.get(c) == null) {
                results.add(0);
            } else {
                results.add(1);
            }
            history.put(c, i);
            i++;
        }
        return results.stream().mapToInt(n -> n).toArray();
    }
}

class SeenAfter {
    private String input;

    SeenAfter(String input) {
        this.input = input;
    }

    public int[] results() {
        String[] tmparray = this.input.split("");
        int[] results = new int[tmparray.length];
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = tmparray.length - 1 ; i >= 0; i--) {
            if (map.get(tmparray[i]) == null) {
                map.put(tmparray[i], 1);
                results[i] = 0;
            } else {
                results[i] = 1;
            }
        }
        return results;
    }
}
