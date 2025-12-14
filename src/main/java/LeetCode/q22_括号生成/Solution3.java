package LeetCode.q22_括号生成;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Young
 * @Date: 2023/11/27 21:58
 */
// 方法三：按括号序列的长度递归
// 任何一个括号序列都一定是由 ‘(’开头，并且第一个 ‘(’ 一定有一个唯一与之对应的 ‘)'
// 这样一来，每一个括号序列可以用 (a)b来表示，其中 a 与 b 分别是一个合法的括号序列（可以为空）
// ans.add("(" + left + ")" + right) 实际上是固定一个 ()  在此基础上增长而来
// n=0是 ""  n=1 是 （）, n=2 是  (()) 、（）（）
//  例如 n=3  是 a=0 b=2 , a=1  b=1, a=2 b=0,

public class Solution3 {
    ArrayList[] cache = new ArrayList[100];

    public List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }

        ArrayList<String> ans = new ArrayList<>();
        if ( n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; c++) {
                for (String left : generate(c)) {
                    for (String right : generate(n -1 -c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }

    public List<String> generateParenthesis(int n) {
        return generate(n);
    }

}
