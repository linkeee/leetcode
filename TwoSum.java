import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

/**
 * Key point: HashMap能够将查找时间缩短到O(1)!
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[] { 2, 3, 5, 7, 11, 15 };
        int target = 26;

        long startTime = System.currentTimeMillis();
        Solution.solution3(nums, target);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms。");

        for (int item : Solution.solution3(nums, target)) {
            System.out.println(item);
        }
    }
}

class Solution {
    /**
     * 双重循环 时间复杂度：O(n^2) 空间复杂度：O(1)
     */
    public static int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { nums[i], nums[j] };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution.");
    }

    /**
     * 两次遍历哈希表 我们需要一种更有效的方法来检查数组中是否存在目标元素。如果存在，我们需要找出它的索引。
     * 保持数组中的每个元素与其索引相互对应的最好方法是哈希表。 时间复杂度：O(n) 空间复杂度：O(n)
     */
    public static int[] solution2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // 哈希表查找的时间复杂度为O(1)
            if (map.containsKey(complement) && (map.get(complement) != i)) {
                return new int[] { nums[i], complement };
            }
        }
        throw new IllegalArgumentException("No two sum solution.");
    }

    /**
     * 一次遍历哈希表
     * 每次检查新添加的能否和前边添加的配对
     * 时间复杂度：O(n) 空间复杂度：O(n)
     */
    public static int[] solution3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // 哈希表查找的时间复杂度为O(1)
            if (map.containsKey(complement) && (map.get(complement) != i)) {
                return new int[] { complement, nums[i] };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution.");
    }
}