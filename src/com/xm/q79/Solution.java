package com.xm.q79;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by xm on 17-10-19.
 */
public class Solution {
    /**
      * @param A: A string
      * @param B: A string
      * @return: the length of the longest common substring.
      */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if(A==null || B==null || A.length()==0 || B.length()==0){
            return 0;
        }
        char[] aArray = A.toCharArray();
        char[] bArray = B.toCharArray();
        int[][] resultTable = new int[bArray.length][aArray.length];
        int maxLength = 0;

        for(int x=0; x<aArray.length;x++){
            for(int y=0;y<bArray.length;y++){
                int leftTopNum = ((y==0)||(x==0))?0:resultTable[y-1][x-1];
                int length = aArray[x]==bArray[y]?leftTopNum+1:0;
                resultTable[y][x] = length;
                if(length>maxLength){
                    maxLength = length;
                }
            }
        }

        return maxLength;
    }

}