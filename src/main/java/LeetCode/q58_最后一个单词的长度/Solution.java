package LeetCode.q58_最后一个单词的长度;

/**
 * @Author: Young
 * @Date: 2025/6/10 01:44
 * 方法一：反向遍历
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        // 去除末尾空格
        while (s.charAt(index) == ' ') {
            index--;
        }

        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }

        return wordLength;

    }

}
