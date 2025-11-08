package Algorithms.a01Searching.binarySearch.basicAndEdge;

import java.util.Scanner;

//闭区间
public class closeInterval {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int target = sc.nextInt();
        int[] nums ={1,3,5,7,9,11,12,16,19,52};
        System.out.println(binarySearch(nums, target));

    }
    static int binarySearch(int[] nums,int target){
        int i=0,j=nums.length-1;
        int m;
        while(i<=j){
            m=i+j>>>1;
            if(nums[m]==target){
                return m;
            } else if (nums[m]<target) {
                i=m+1;
            } else if (target<nums[m]) {
                j=m-1;
            }
        }
        return  -1;
    }

}
