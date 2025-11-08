package Algorithms.Exercise;
//20251108手打一个三路快排
/*复习:
行进中[lt,i-1]是等于pivot的区域
[i,gt]是未处理的区域
最后i=gt+1循环结束
此时gt=i-1
所以等于pivot的区域是[lt,gt]
*/


public class Exercise6 {
    public static void main(String[] args) {

    }
    void sort(int[] nums){
        if(nums==null||nums.length<=1){
            return;
        }
        quickSort(nums,0,nums.length-1);
    }
    void quickSort(int[] nums,int low,int high){
        if(low < high){
            int[] partition = partition(nums, low, high);
            quickSort(nums, low,partition[0]-1);
            quickSort(nums,partition[1]+1, high);
        }
    }
    int[] partition(int[] nums,int low,int high){
        int lt = low;
        int gt = high;
        int i = low+1;
        int pivot = nums[low];
        int tmp;
        while(i<=gt){
            if(nums[i]<pivot){
                tmp = nums[i];
                nums[i] = nums[lt];
                nums[lt] = tmp;
                i++;
                lt++;
            }else if(nums[i]>pivot){
                tmp = nums[i];
                nums[i] = nums[gt];
                nums[gt] = tmp;
                gt--;
            }else {
                i++;
            }
        }
        return new int[]{lt,gt};

    }


}
