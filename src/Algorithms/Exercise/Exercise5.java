package Algorithms.Exercise;


//20251108手打快速排序练习
public class Exercise5 {
    public static void main(String[] args) {

    }
    void sort(int[] nums){
        if(nums==null||nums.length<=1){
            return;
        }
        quickSort(nums,0,nums.length-1);
    }
    void quickSort(int[] nums,int left,int right){
        if(left<right){
            int partition = partition(nums,left,right);
            quickSort(nums,left,partition-1);
            quickSort(nums,partition+1,right);
        }
    }
    int partition(int[] nums,int left,int right){
        int pivot = nums[left];
        while(left<right){
            while(left<right&&nums[right]>=pivot){//这里的等于和下面的等于可以只写一个
                right--;
            }
            nums[left] = nums[right];
            while(left<right&&nums[left]<=pivot){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }



}
