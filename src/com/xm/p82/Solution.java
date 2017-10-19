package com.xm.p82;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * Created by xm on 17-10-19.
 */
public class Solution {

    /*
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {
        // write your code here
        if(A.length==0){
            return 0;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i:A){
            if(!hashSet.contains(i)){
                hashSet.add(i);
            }else{
                hashSet.remove(i);
            }
        }

        return hashSet.toArray(new Integer[0])[0];
    }
}