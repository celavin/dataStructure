package leetCode;
//滚动数组版本
public class leetCode198ver2 {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int a = nums[0];
        int b = Math.max(nums[0],nums[1]);
        //我只用到了dp[i-1]和dp[i-2],可以简化成两个变量
        int tmp;

        for (int i = 2; i <nums.length ; i++) {
            // rob or not rob, its a question
            tmp = b;
            b = Math.max(a+nums[i],b);
            a = tmp;
        }
        return b;
    }
}
