package Algorithms.a02Sort.b01ComparisonSort.HeapSort;

public class HeapSort {
    static void sort(int[] nums){
        if(nums==null||nums.length<=1){
            return;
        }
        heapsort(nums);

    }
    static void heapsort(int[] nums){
        //第一步,建堆
        buildHeap(nums);
        //第二步,循环交换调整
        int temp;
        for (int i = nums.length-1; i>0 ; i--) {
            //交换
            temp = nums[i];
            nums[i]=nums[0];
            nums[0]=temp;
            //然后是调整
            heapify(nums,i,0);//这里的length是i,因为最后一个值已经被固定住了
        }

    }
    static void buildHeap(int[] nums){//建堆,自下而上
        int length = nums.length;
        for (int i = (nums.length-2)/2; i>=0 ; i--) {
            heapify(nums,length,i);
        }
    }
    static void heapify(int[] nums,int length,int node){
        int maxindex = node;
        int leftchild = node*2+1;
        int rightchild = node*2+2;
        if(leftchild<length&&nums[leftchild]>nums[maxindex]){
            maxindex = leftchild;
        }
        if(rightchild<length&&nums[rightchild]>nums[maxindex]){
            maxindex = rightchild;
        }
        if(maxindex != node){
            int temp = nums[node];
            nums[node]=nums[maxindex];
            nums[maxindex]=temp;
            heapify(nums,length,maxindex);//调整后子树可能不再满足堆序性,递归调整
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};
        sort(arr);
        for (int num : arr) {
            System.out.print(num + " "); // 输出：1 3 4 5 10
        }
    }

}
