package Algorithms.a01Searching.binarySearch.SearchinRotatedSortedArray;
//怎么说呢,就是看两边哪边是有序的,然后在看target是否在里面

//问:判断哪边有序后又要判断target在哪里,但最后还是前往target,那不是有点多此一举了吗
//答:因为我不知道target在哪里,只能找到有序区间才能判断target是否在里面,如果不在就是在另一个区间
public class leetcode33 {
    public static void main(String[] args) {

    }
    public static int search(int[] nums,int target){
        int i = 0,j=nums.length-1;
        int m;
        while(i<=j){
            m=i+j>>>1;
            if(nums[m]==target){
                return m;
            } else if (nums[i] <= nums[m]) {//说明左边是有序的,然后看target是否在里面
                if(nums[i] <=target &&target < nums[m]){
                    j=m-1;
                }else{i=m+1;}
            } else if (nums[m] < nums[i]) {//说明右边是有序的,然后看target是否在里面
                if(nums[m] <target &&target <= nums[j]){
                    i=m+1;
                }else{j=m-1;}
            }
        }
        return -1;
    }

}
