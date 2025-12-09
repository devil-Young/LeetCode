package 比赛的冠亚季军;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @Author: Young
 * @Date: 2025/11/15 07:50
 */
public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        List<long[]> players = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            players.add(new long[]{Long.parseLong(input[i], i)});
        }
        List<long[]> thirdCandidates = new ArrayList<>();
        long[] runnerUp = null; // 亚军
        while (players.size() > 1) {
            int size = players.size();
            List<long[]> nextRound = new ArrayList<>();
            for (int i = 0; i < size; i += 2) {
                if (i + 1 < size) {
                    long[] a = players.get(i);
                    long[] b = players.get(i + 1);
                    int cmp = compare(a, b);

                    long[] winner = cmp > 0 ? a : b; // 胜者
                    long[] loser = cmp > 0 ? b : a;   // 败者
                    if (size == 4 || size == 3) {
                        thirdCandidates.add(loser);
                    }
                    if (size == 2) runnerUp = loser;
                    nextRound.add(winner);
                }else {
                    nextRound.add(players.get(i));
                }
            }
            players = nextRound;

        }
        long[] champion = players.get(0);
        long[] third = thirdCandidates.size() == 1 ?
                thirdCandidates.get(0) :
                compare(thirdCandidates.get(0), thirdCandidates.get(1)) > 0 ?
                        thirdCandidates.get(0) : thirdCandidates.get(1);

        // 输出冠亚季军的id
        System.out.println(champion[1] + " " + runnerUp[1] + " " + third[1]);

    }

    private static int compare(long[] a, long[] b) {
        if (a[0] != b[0]) {
            return Long.compare(a[0], b[0]);
        }
        return Long.compare(b[1], a[1]);
    }
}
