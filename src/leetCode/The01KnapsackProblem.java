package leetCode;

public class The01KnapsackProblem {
    public static void main(String[] args) {

    }
    public int findMaxValue(int weight,int[] weights,int[] values){
        if(weights.length!=values.length){
            return -1;
        }
        int amount = weights.length;
        int maxValue = 0;

        int[] dp = new int[weight+1];//代表对应重要储存最高价值
        for (int i = 0; i < amount ; i++) {
            for (int j = weight; j >=weights[i] ; j--) {
                dp[j] = Math.max(dp[j],dp[j-weights[i]]+values[i]);
            }
        }
        return maxValue;
    }
}
