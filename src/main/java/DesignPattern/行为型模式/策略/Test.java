package DesignPattern.行为型模式.策略;

import java.util.Arrays;

import static java.util.Arrays.sort;

/**
 * @Author: Young
 * @Date: 2025/12/14 17:05
 */
public class Test {
    public static void main(String[] args) {

            String[] array = { "apple", "Pear", "Banana", "orange" };
            sort(array, String::compareToIgnoreCase);
            System.out.println(Arrays.toString(array));

    }
}
