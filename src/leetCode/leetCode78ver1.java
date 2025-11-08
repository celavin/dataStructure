package leetCode;

import java.util.ArrayList;
import java.util.List;

/*给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。*/

//把求子集转换成n个求组合的问题
public class leetCode78ver1 {
    public static void main(String[] args) {

    }
    int n;
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        for (int n = 0; n <= nums.length; n++) {
            this.n = n;
            backtrack(new ArrayList<>(),nums,0);
        }
        return result ;
    }
    void backtrack(ArrayList<Integer> current , int[] nums,int start){
        if(current.size()==n){
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <nums.length ; i++) {
            current.add(nums[i]);
            backtrack(current,nums,i+1);
            current.remove(current.size()-1);
        }
    }

}
