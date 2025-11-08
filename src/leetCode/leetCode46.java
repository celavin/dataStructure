package leetCode;

import java.util.ArrayList;
import java.util.List;

/*给定一个不含重复数字的数组 nums ，
返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。*/

//回溯.好巧妙
//
public class leetCode46 {
    public static void main(String[] args) {

    }
    List<List<Integer>> result = new ArrayList<>();
    boolean[] used; // 状态数组

    public List<List<Integer>> permute(int[] nums) {
        // used[i] = true 表示 nums[i] 已经被用过了
        used = new boolean[nums.length];
        backtrack(new ArrayList<>(), nums);
        return result;
    }

    void backtrack(List<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 这次我们遍历 *索引* i, 而不是数字 num
        for (int i = 0; i < nums.length; i++) {
            // 剪枝: 如果 nums[i] 已经被用过了, 跳过
            if (used[i]) {
                continue;
            }

            // 3. 做出选择
            path.add(nums[i]);
            used[i] = true; // 标记 nums[i] 为 "已使用"

            // 4. 递归
            backtrack(path, nums);

            // 5. 撤销选择
            path.remove(path.size() - 1);
            used[i] = false; // 取消标记, 这样别的分支才能用
        }
    }
}
