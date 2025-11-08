package Algorithms.a01Searching.binarySearch.basicAndEdge;

import java.util.Scanner;

public class openInterval {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int target = sc.nextInt();
        int[] nums ={1,3,5,7,9,11,12,16,19,52};
        System.out.println(binarySearch(nums, target));

    }
    static int binarySearch(int[] nums,int target){
        int i=0,j=nums.length;//因为是开区间,要确保最后一个元素在区间内
        int m;
        while(i<j){//相等时区间为空,应结束
            m=i+j>>>1;
            if(nums[m]==target){
                return m;
            } else if (nums[m]<target) {
                i=m+1;
            } else if (target<nums[m]) {
                j=m;//如果是m-1则会让m-1的值在区间外
            }
        }
        return  -1;
    }
}
