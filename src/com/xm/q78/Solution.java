package com.xm.q78;

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
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        int strMaxLength = 0;
        //找到最大长度字符串
        for(String str:strs){
            if(str==null){
                return null;
            }
            if(str.length()==0){
                return "";
            }
            if(str.length()>strMaxLength){
                strMaxLength = str.length();
            }
        }

        StringBuilder resultString = new StringBuilder("");
        for(int i=0;i<strMaxLength;i++){
            boolean allPass = true;
            char currentPositionChar = 'a';
            for(int j=0;j<strs.length;j++){
                if(j==0){
                    currentPositionChar = strs[j].charAt(i);
                    continue;
                }
                if(strs[j].charAt(i) != currentPositionChar){
                    allPass = false;
                    break;
                }
            }
            if(allPass){
                resultString.append(currentPositionChar);
            }else{
                return resultString.toString();
            }
        }
        return resultString.toString();
    }
}