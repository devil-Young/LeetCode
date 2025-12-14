package LeetCode.q56_合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Young
 * @Date: 2025/2/17 01:04
 * 所有能够合并的区间都必然是连续的
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][2];

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        ArrayList<int[]> merged = new ArrayList<>();
        for (int i = 0; i <  intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.isEmpty() || merged.getLast()[1] < L) {
                merged.add(new int[]{L, R});
            }else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
