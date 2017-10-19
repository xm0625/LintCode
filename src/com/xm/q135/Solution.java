package com.xm.q135;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created by xm on 17-10-19.
 */
public class Solution {
    /**
     * @param s: The first string
     * @param t: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        HashMap<String, Integer> sMap = new HashMap<>();
        HashMap<String, Integer> tMap = new HashMap<>();

        transStrToMap(s, sMap);
        transStrToMap(t, tMap);

        if(sMap.keySet().size() != tMap.keySet().size()){
            return false;
        }

        for(Object charString:sMap.keySet()){
            if(!tMap.keySet().contains(charString) || !(sMap.get(charString).equals(tMap.get(charString)))){
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