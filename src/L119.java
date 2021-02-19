import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角
 * 给定一个非负索引 k，其中 k ≤ 33，
 * 返回杨辉三角的第 k 行。
 */

public class L119 {
    public List<Integer> getRow(int k) {
        List<Integer> res = new ArrayList<>();
        if(k < 0) {
            return res;
        }

        // dp: row[k-1] ==> row[k]
        int[] cur = new int[]{1};
        for(int i=1; i<k+1; i++){
            int[] newRow = new int[i+1];
            newRow[0] = 1;
            newRow[i] = 1;
            for(int j=1; j<i; j++) {
                    newRow[j] = cur[j-1] + cur[j];
            }
            cur = newRow;
        }
        for(int i:cur) {
            res.add(i);
        }
        return res;
    }
}
