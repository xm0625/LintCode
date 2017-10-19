package com.xm.q138;

import java.util.*;

/**
 * Created by xm on 17-10-19.
 */
public class Solution {
    /**
         * @param nums: A list of integers
         * @return: A list of integers includes the index of the first number and the index of the last number
         */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            for(int j=i;j<nums.length;j++){
                sum = sum + nums[j];
                if(sum==0){
                    List<Integer> result = new ArrayList<>();
                    result.add(i);
                    result.add(j);
                    return result;
                }
            }
        }
        return new ArrayList<>();
    }
}