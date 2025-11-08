package Algorithms.a01Searching.binarySearch.binaryOnAnswer;

import java.util.Arrays;

/*传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。

传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。

返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。*/
public class leetcode1011 {
    public static void main(String[] args) {
        int[] weights ={3,2,2,4,1,4};
        int days = 3;
        System.out.println(shipWithinDays(weights,days));
    }
    public static int shipWithinDays(int[] weights, int days) {
        int i=Arrays.stream(weights).max().getAsInt(),j= Arrays.stream(weights).sum();
        int pos = j;
        int m;
        while(i<=j){
            m=i+j>>>1;
            if(check(m,weights,days)==true){
                pos=m;
                j=m-1;
            }
            else{i=m+1;}
        }
        return pos;
    }
    static boolean check(int hold,int[] weights, int days){
        int[] dayschedule = new int[days];
        int countday = 0;
        int p = 0;
        while(p<=weights.length-1){
            if(dayschedule[countday]+weights[p]<=hold) {
                dayschedule[countday] += weights[p];
                p += 1;
            }else{
                countday++;
            }
            if(countday>=days){
                return false;
            }
        }
        return countday<days;
    }

}
