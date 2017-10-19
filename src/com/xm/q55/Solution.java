package com.xm.q55;

import java.util.HashMap;

/**
 * Created by xm on 17-10-19.
 */
public class Solution {

    /*
     * @param A: A string
     * @param B: A string
     * @return: if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        HashMap<String, Integer> aMap = new HashMap<>();
        HashMap<String, Integer> bMap = new HashMap<>();

        transStrToMap(A, aMap);
        transStrToMap(B, bMap);

        for(Object charString:bMap.keySet()){
            if(!aMap.keySet().contains(charString) || !(aMap.get(charString)>=bMap.get(charString))){
                return false;
            }
        }

        return true;
    }


    private void transStrToMap(String s, HashMap<String, Integer> map){
        char[] charArray = s.toCharArray();
        for(char c:charArray){
            if(map.keySet().contains(String.valueOf(c))){
                map.put(String.valueOf(c), map.get(String.valueOf(c))+1);
            }else{
                map.put(String.valueOf(c), 1);
            }
        }
    }

}