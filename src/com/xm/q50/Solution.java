package com.xm.q50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by xm on 17-10-19.
 */
public class Solution {
    /*
     * @param nums: Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here
        List<Long> resultList = new ArrayList<>();
        if(nums == null || nums.size()<=1){
            resultList.add((long) 1);
            return resultList;
        }
        HashMap<String, Long> numsProductMap = new HashMap<>();
        for(int i =0;i<nums.size();i++){
            if(i==0){
                numsProductMap.put("0,"+i, nums.get(i).longValue());
            }else{
                numsProductMap.put("0,"+i, nums.get(i)*(numsProductMap.get("0,"+(i-1))));
            }
        }
        int lastIndex = nums.size()-1;
        for(int i =lastIndex;i>=0;i--){
            if(i==lastIndex){
                numsProductMap.put(i+","+lastIndex, nums.get(i).longValue());
            }else{
                numsProductMap.put(i+","+lastIndex, nums.get(i)*(numsProductMap.get((i+1)+","+lastIndex)));
            }
        }
        for(int i =0;i<nums.size();i++){
            if(i==0){
                resultList.add(numsProductMap.get((i+1)+","+lastIndex));
                continue;
            }
            if(i==lastIndex){
                resultList.add(numsProductMap.get("0,"+(lastIndex-1)));
                continue;
            }
            resultList.add(numsProductMap.get("0,"+(i-1))*numsProductMap.get((i+1)+","+lastIndex));
        }
        return resultList;
    }
}