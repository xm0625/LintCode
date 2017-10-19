package com.xm.q65;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by xm on 17-10-19.
 */
public class Solution {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        ArrayList<Integer> resultArray = new ArrayList<>();
        for(Integer i:A){
            resultArray.add(i);
        }
        for(Integer i:B){
            resultArray.add(i);
        }
        resultArray.sort(Comparator.<Integer>naturalOrder());
        if(resultArray.size()==1){
            return resultArray.get(0);
        }
        if(resultArray.size()%2==0){
            return (resultArray.get(resultArray.size()/2-1)+resultArray.get(resultArray.size()/2))/2.0;
        }
        return resultArray.get(resultArray.size()/2);
    }
}