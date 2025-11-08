package Algorithms.a01Searching.binarySearch.var;

import java.util.Scanner;
//找到最右边的(最后)target
public class var2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int target = sc.nextInt();
        int[] nums ={1, 2, 2, 2, 3,3,4};
        System.out.println(binarySearch(nums, target));

    }
    static int binarySearch(int[] nums,int target){
        int i=0,j=nums.length-1;
        int m;
        int pos=-1;
        while(i<=j){
            m=i+j>>>1;
            if(nums[m]==target){
                pos = m;//这是一个可能的答案
                i=m+1;//答案要么是本身要么在右边
            } else if (nums[m]<target) {
                i=m+1;
            } else if (target<nums[m]) {
                j=m-1;
            }
        }
        return  pos;
    }
}
