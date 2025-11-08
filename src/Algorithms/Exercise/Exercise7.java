package Algorithms.Exercise;
//20251108手打一个归并排序
//有一点难
public class Exercise7 {
    public static void main(String[] args) {

    }
    void sort(int[] nums){
        if(nums==null||nums.length<=1){
            return;
        }
        mergeSort(nums,0,nums.length-1);
    }
    void mergeSort(int[] nums,int left,int right){
            if(left>=right)return;
            int mid = left + (right-left)/2;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
            merge(nums,left,mid,right);

    }
    void merge(int[] nums,int left,int mid,int right){
        int[] tmp = new int[right-left+1];
        int index = 0;
        int i = left;
        int j = mid+1;
        while(i<=mid&&j<=right){
            if(nums[i]<=nums[j]) {tmp[index] = nums[i];i++;}
            else {tmp[index] = nums[j];j++;}
            index++;
        }
        while(j<=right){
            tmp[index] = nums[j];
            index++;
            j++;
        }
        while(i<=mid){
            tmp[index] = nums[i];
            index++;
            i++;
        }
        for (int k = left; k <=right ; k++) {
            nums[k] = tmp[k-left];
        }
    }



}
