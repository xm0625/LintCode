package com.xm.q171;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by xm on 17-10-19.
 */
public class Solution {

    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        HashMap<String, CountInfo> strCount = new HashMap<>();
        for(String str:strs){
            String charInfoString = transStrToCharInfoString(str);
            if(!strCount.keySet().contains(charInfoString)){
                strCount.put(charInfoString,new CountInfo(str));
            }else{
                CountInfo countInfo = strCount.get(charInfoString);
                countInfo.count++;
                countInfo.strList.add(str);
            }
        }
        ArrayList resultList = new ArrayList();
        for(String charInfoString:strCount.keySet()){
            CountInfo countInfo =strCount.get(charInfoString);
            if(countInfo.count>1){
                resultList.addAll(countInfo.strList);
            }
        }
        return resultList;
    }

    class CountInfo{
        int count=0;
        ArrayList<String> strList = new ArrayList<>();

        CountInfo(String originalString){
            strList.add(originalString);
            count++;
        }
    }

    private String transStrToCharInfoString(String s){
        StringBuilder result = new StringBuilder("");
        HashMap<String, Integer> sMap = new HashMap<>();
        char[] charArray = s.toCharArray();
        for(char c:charArray){
            if(sMap.keySet().contains(String.valueOf(c))){
                sMap.put(String.valueOf(c), sMap.get(String.valueOf(c))+1);
            }else{
                sMap.put(String.valueOf(c), 1);
            }
        }

        String[] keys = sMap.keySet().toArray(new String[]{});
        Arrays.sort(keys);
        for(String key:keys){
            result.append(key+sMap.get(key));
        }
        return result.toString();
    }
}