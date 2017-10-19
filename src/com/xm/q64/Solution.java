package com.xm.q64;

/**
 * Created by xm on 17-10-19.
 */
public class Solution {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int lastInsertPoint = 0;
        for(int i=0;i<n;i++){
            int bNum = B[i];
            for(int j=lastInsertPoint;j<m+n;j++){
                if(A[j]==0){
                    //为空 直接插入
                    insert(A, m+n, bNum, j);
                    lastInsertPoint = j;
                    break;
                }
                if(bNum>=A[j] && bNum<A[j+1]){
                    //大于当前值小于后面的值, 插入后面
                    insert(A, m+n, bNum, j+1);
                    lastInsertPoint = j;
                    break;
                }
                if(bNum<A[j]){
                    //小于当前值, 插入当前
                    insert(A, m+n, bNum, j);
                    lastInsertPoint = j;
                    break;
                }
            }
        }
    }

    private void insert(int[] array, int arrayLength, int insertNum, int insertAt){
        int originalNum = insertNum;
        int swapTemp = 0;
        for(int i=insertAt;i<arrayLength;i++){
            swapTemp = array[i];
            array[i] = originalNum;
            originalNum = swapTemp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.mergeSortedArray(new int[]{1,3,4,6,0,0}, 4, new int[]{2, 5}, 2);
    }
}