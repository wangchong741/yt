package com.likou.shuzu.jianzhioffer;

import java.util.HashSet;
import java.util.Set;

/**
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * @author wangchong35962
 * @date 2021-07-08 14:18
 */
public class Test03 {

    public static void main(String[] args) {
        int repeatNumber = findRepeatNumber(new int[]{1, 2, 3, 4, 1});
        System.out.println(repeatNumber);
    }

    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }
}
