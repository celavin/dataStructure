package Algorithms.a01Searching.binarySearch.var;

import java.util.Scanner;

//寻找第一个大于等于 target 的元素
public class var3 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int target = sc.nextInt();
        int[] nums ={1, 2, 2, 2, 3,3,4};
        System.out.println(binarySearch(nums, target));

    }
    static int binarySearch(int[] nums,int target){
        int i=0,j=nums.length-1;
        int m;
        int pos=nums.length;//没有比tatget大时的默认答案
        while(i<=j){
            m=i+j>>>1;
            if(nums[m]>=target){
                pos = m;//这是一个可能的答案
                j=m-1;//答案要么是本身要么在左边
            } else if (nums[m]<target) {
                i=m+1;
            }
        }
        return  pos;
    }
}
