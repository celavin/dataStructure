package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

你可以按 任何顺序 返回答案。*/
public class leetCode77 {
    public static void main(String[] args) {

    }
    int n;
    int k;
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(new ArrayList<Integer>(),1);
        return result;

    }
    void backtrack(List<Integer> nums,int start){
        if(nums.size()==k){
            result.add(new ArrayList<>(nums));
            return;
        }
        for (int i = start; i <=n ; i++) {

            nums.add(i);
            backtrack(nums,i+1);
            nums.remove(nums.size()-1);
        }
    }

}
