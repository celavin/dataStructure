package leetCode;

public class leetCode643 {
    public static void main(String[] args) {

    }
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        int i = 0;
        int j = k-1;
        for (int i1 = 0; i1 < k; i1++) {
            sum+=nums[i1];
        }
        double maxsum = sum;
        while(j<nums.length-1){
            sum -= nums[i];
            i += 1;
            j += 1;
            sum += nums[j];
            maxsum = Math.max(maxsum,sum);
        }
        return maxsum/k;
    }
}
