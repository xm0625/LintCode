package com.xm.q172;

import java.util.ArrayList;

/**
 * Created by xm on 17-10-19.
 */
public class Solution {

    public int removeElement(int[] A, int elem) {
        // write your code here
        int confirmedIndex = 0;
        for(int i=0;i<A.length;i++){
            if(A[i] == elem){
                A[i] = 0;
                continue;
            }
            if(confirmedIndex!=i){
                A[confirmedIndex] = A[i];
                A[i] = 0;
            }
            confirmedIndex++;
        }
        return confirmedIndex;
    }
}