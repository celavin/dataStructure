package Algorithms.a02Sort.b02LinearTimeSort.countingSort;

import java.util.Arrays;
//标准版,count 记录小于等于该索引的值的数量.也就是记录完后要累加
//相比简易版,它即使排对象也拥有稳定性
//看上去比简易版复杂了一点,过程如下:

/*前面不变,count完成后累加,这样子,count[x]的值代表了最后一个x应该放在的位置+1
比如count[2]=4,说明最后一个2应该放在索引3
然后,新建立一个结果数组.为了保证稳定性,我们从后面往前遍历原数组
如果nums[10]=4,我们查count[4]=7,说明最后一个4应该放在索引6,填入结果数组,然后nums[10]-1.
说明下一次最后一个4应该放在索引5
直到遍历完原数组.结果数组也填完了
nums里面没有的值在count里面不会被访问到,所以无需担心

 */

//经过审查,无法处理负数,同时最大值很大的时候很浪费,可以找最小值确定范围,以后再写吧
public class standardCountingSort {

    public static void main(String[] args) {
        int[] nums ={3,7,5,5,7,2,1,1,6};
        System.out.println(Arrays.toString(sort(nums)));

    }
    static int[] sort(int[] nums){
        if(nums == null || nums.length<=1){
            return nums;
        }
        return countingSort(nums);
    }
    static int[] countingSort(int[] nums){
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>max){
                max = nums[i];
            }
        }
        int[] count = new int[max+1];
        for (int v : nums) {
            count[v]+=1;
        }
        for (int i = 1; i < count.length; i++) {//累加
            count[i] += count[i-1];
        }
        int[] newnums = new int[nums.length];
        for (int i = nums.length-1;i >=0; i--) {
            newnums[count[nums[i]]-1]=nums[i];
            count[nums[i]]--;
        }
        return newnums;
    }

}
