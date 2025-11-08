package Algorithms.a01Searching.binarySearch.binaryOnAnswer;
//珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
//
//珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
//
//珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
//
//返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）

import java.util.Arrays;

public class leetcode875 {
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        int k = minEatingSpeed(piles,h);
        System.out.println(k);
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int i = 1,j= Arrays.stream(piles).max().getAsInt();
        int m;
        int pos=-1;
        while(i<=j){
            m=i+j>>>1;
            if(check(m,piles,h)==true){
                pos = m;
                j=m-1;
            }
            else{
                i=m+1;
            }
        }
        return pos;
    }
    static boolean check(int speed, int[] piles, int h){
        long totalHours = 0; // 使用long防止整数溢出

        for (int pile : piles) {
            // 计算吃完这堆香蕉需要的小时数
            // 公式：小时数 = ceil(香蕉数 / 速度)
            totalHours += (pile + speed - 1) / speed;

            // 如果已经超过h小时，提前返回false
            if (totalHours > h) {
                return false;
            }
        }

        return totalHours <= h;
    }

}
