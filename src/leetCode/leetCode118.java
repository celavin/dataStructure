package leetCode;

import java.util.ArrayList;
import java.util.List;

/*给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。

在「杨辉三角」中，每个数是它左上方和右上方的数的和。*/
public class leetCode118 {
    public static void main(String[] args) {
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> dp = new ArrayList<>();
        dp.add(1);
        result.add(dp);
        for (int i = 1; i < numRows; i++) {
            dp = new ArrayList<>();
            dp.add(1);
            for (int j = 1; j < i ; j++) {
                dp.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
            }
            dp.add(1);
            result.add(dp);

        }
        return result;


    }

}
