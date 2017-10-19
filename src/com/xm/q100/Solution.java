package com.xm.q100;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xm on 17-10-19.
 */
public class Solution {
    /**
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        ArrayList<Integer> arrayList = new ArrayList<>();
        int confirmedIndex = 0;
        for(int i=0;i<nums.length;i++){
            if(!arrayList.contains(nums[i])){
                arrayList.add(nums[i]);
                if(confirmedIndex!=i){
                    nums[confirmedIndex]  = nums[i];
                    nums[i]=0;
                }
                confirmedIndex++;
            }else{
                nums[i]=0;
            }
        }
        return confirmedIndex;
    }
}