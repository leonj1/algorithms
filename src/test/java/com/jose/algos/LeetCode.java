package com.jose.algos;

import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created for K and M Consulting LLC.
 * Created by Jose M Leon 2018
 **/
public class LeetCode {

    @Test
    public void testTwoSum() {
        // Given nums = [2, 7, 11, 15], target = 9,
//        Because nums[0] + nums[1] = 2 + 7 = 9,
//        return [0, 1].

        int[] result = twoSum(new int[]{2,7,11,15}, 9);
        assertThat(result, equalTo(new int[]{0,1}));
        result = twoSum(new int[]{2,5,5,11}, 10);
        assertThat(result, equalTo(new int[]{1,2}));
    }

    int[] twoSum(int[] arr, int target) {
        for(int i=0; i<arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if((arr[i] + arr[j]) == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}
