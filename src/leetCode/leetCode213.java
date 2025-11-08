package leetCode;
/*你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
这个地方所有的房屋都 围成一圈 ，
这意味着第一个房屋和最后一个房屋是紧挨着的。
同时，相邻的房屋装有相互连通的防盗系统，
如果两间相邻的房屋在同一晚上被小偷闯入，
系统会自动报警 。
给定一个代表每个房屋存放金额的非负整数数组，
计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。*/

//198的升级版,成环了,分两种情况讨论,偷不偷第一家,能够包含所有情况
public class leetCode213 {
    public static void main(String[] args) {

    }
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        return Math.max(rob(nums,1,nums.length-1),rob(nums,0,nums.length-2));
    }
    int rob(int[] nums,int i,int j){
        if(i==j)return nums[i];
        int pretwo = nums[i];
        int preone = Math.max(nums[i],nums[i+1]);
        int current;
        for (int k = i+2; k <=j ; k++) {
            current = preone;
            preone = Math.max(preone,pretwo+nums[k]);
            pretwo = current;
        }
        return preone;
    }

}
