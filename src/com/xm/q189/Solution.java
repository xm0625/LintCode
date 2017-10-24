package com.xm.q189;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by xm on 17-10-19.
 */
public class Solution {
    /*
     * @param A: An array of integers
     * @return: An integer
     */
    public int firstMissingPositive(int[] A) {
        // write your code here
        if(A==null || A.length==0){
            return 1;
        }
        Arrays.sort(A);
        HashSet<Integer> hashSet = new HashSet<>();
        for(int a:A){
            hashSet.add(a);
        }
        for(int i=1;i<A[A.length-1]+2;i++){
            if(!hashSet.contains(i)){
                return i;
            }
        }
        return 1;
    }
}