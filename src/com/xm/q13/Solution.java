package com.xm.q13;

import java.util.HashMap;

/**
 * Created by xm on 17-10-19.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("acbaldcacde", "adc"));
    }

    /*
     * @param source: source string to be scanned.
     * @param target: target string containing the sequence of characters to match
     * @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
     */
    public int strStr(String source, String target) {
        // write your code here

        if(source==null || target==null){
            return -1;
        }

        char[] sourceCharArray = source.toCharArray();
        char[] targetCharArray = target.toCharArray();

        if(target.length()==0){
            return 0;
        }
        char targetFirstChar = targetCharArray[0];
        for(int i=0;i<=sourceCharArray.length-target.length();i++){
            if(sourceCharArray[i] == targetFirstChar){
                MatchResult matchResult = tryMatch(sourceCharArray, targetCharArray, i);
                if(matchResult.matchSuccess){
                    return i;
                }else{
                    i=matchResult.seekPoint==0?i:matchResult.seekPoint-1;
                }
            }
        }

        return -1;
    }

    private MatchResult tryMatch(char[] sourceCharArray, char[] targetCharArray, int sourceCharArrayIndex) {
        MatchResult matchResult = new MatchResult();
        for(int i=sourceCharArrayIndex; i<sourceCharArrayIndex+targetCharArray.length;i++){
            int targetCharArrayIndex = i-sourceCharArrayIndex;
            if(sourceCharArray[i]!=targetCharArray[targetCharArrayIndex]){
                if(matchResult.matchFailed()){
                    break;
                }
            }
            if((i != sourceCharArrayIndex) && (sourceCharArray[i] == targetCharArray[0])){
                if(matchResult.markSeekPoint(i)){
                    break;
                }
            }
        }
        return matchResult;
    }



    class MatchResult{
        boolean matchSuccess=true;
        int seekPoint = 0;

        boolean matchFailed(){
            matchSuccess = false;
            if(seekPoint>0){
                return true;
            }
            return false;
        }

        boolean markSeekPoint(int seekPoint){

            this.seekPoint = seekPoint;
            if(!matchSuccess){
                return true;
            }
            return false;
        }
    }
}