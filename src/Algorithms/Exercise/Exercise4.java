package Algorithms.Exercise;
//手打一个堆排序
public class Exercise4 {
    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};
        sort(arr);
        for (int num : arr) {
            System.out.print(num + " "); // 输出：1 3 4 5 10
        }

    }
    static void sort(int[] nums){
        if(nums==null||nums.length<=1){
            return;
        }
        heapSort(nums);
    }
    static void heapSort(int[] nums){
        //先建堆
        buildHeap(nums);
        //然后依次把堆顶与末尾调换,循环
        int temp;
        for (int i = nums.length-1; i > 0 ; i--) {
            temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            heapify(nums,0,i);
        }
    }
    static void buildHeap(int[] nums){
        //自下而上建堆法
        //找到最后一个非叶子节点,从他开始往左遍历
        for (int index = (nums.length-2)/2; index>=0;index--) {
            heapify(nums,index,nums.length);
        }

    }
    static void heapify(int[] nums,int index,int length){
        int leftchild = index*2+1;
        int rightchild = index*2+2;
        int maxindex = index;
        int temp;
        if(leftchild<length&&nums[maxindex]<nums[leftchild]){
            maxindex=leftchild;
        }
        if(rightchild<length&&nums[maxindex]<nums[rightchild]){
            maxindex=rightchild;
        }
        if(maxindex!=index){//证明有变换,需要重新验证堆序性
            temp = nums[index];
            nums[index] = nums[maxindex];
            nums[maxindex] = temp;
            heapify(nums,maxindex,length);
        }

    }
}
