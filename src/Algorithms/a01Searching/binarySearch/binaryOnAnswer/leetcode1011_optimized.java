package Algorithms.a01Searching.binarySearch.binaryOnAnswer;

public class leetcode1011_optimized {

    public static void main(String[] args) {
        int[] weights = {3, 2, 2, 4, 1, 4};
        int days = 3;
        System.out.println(shipWithinDays(weights, days)); // 输出应为 6
    }

    public static int shipWithinDays(int[] weights, int days) {
        // --- 优化点 2: 一次遍历计算出二分搜索的左右边界 ---
        int left = 0;  // 船的最低运力（左边界）
        int right = 0; // 船的最高运力（右边界）
        for (int w : weights) {
            left = Math.max(left, w); // 最低运力至少要能装下最重的那个包裹
            right += w;                 // 最高运力就是一天内装完所有包裹
        }

        // pos 这个变量可以省略，直接在循环中更新 right
        // 最终的答案就是 left
        while (left < right) {
            // 使用 (left + right) / 2 防止溢出，虽然在这里 right 不会特别大
            // int mid = left + (right - left) / 2;
            int mid = (left + right) >>> 1; // 你的写法很好，效率很高

            if (check(mid, weights, days)) {
                // 如果 mid 这个运力可行，说明最优解可能更小（或者就是mid）
                // 所以我们尝试在 [left, mid] 这个区间继续搜索
                right = mid;
            } else {
                // 如果 mid 这个运力不可行，说明运力必须比 mid 更大
                // 所以我们必须在 [mid + 1, right] 这个区间搜索
                left = mid + 1;
            }
        }
        // 循环结束时，left 和 right 相遇，这个点就是最小的可行运力
        return left;
    }

    /**
     * 检查给定的运力 (capacity) 是否能在 days 天内运完所有货物
     * @param capacity 假设的船的运力
     * @param weights  包裹重量数组
     * @param days     规定的天数
     * @return 如果可行，返回 true；否则返回 false
     */
    static boolean check(int capacity, int[] weights, int days) {
        // --- 优化点 1: 更高效的 check 逻辑 ---
        int daysNeeded = 1;     // 需要的天数，至少需要1天
        int currentLoad = 0;    // 当前这一天的船已装载的重量

        for (int weight : weights) {//妙啊!
            currentLoad += weight;
            if (currentLoad > capacity) {
                // 当前包裹装不下，需要新的一天
                daysNeeded++;
                // 新的一天从当前这个包裹开始装
                currentLoad = weight;
            }
        }
        // 判断所需天数是否小于等于规定天数
        return daysNeeded <= days;
    }
}