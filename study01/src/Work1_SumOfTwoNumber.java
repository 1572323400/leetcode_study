import java.util.HashMap;
import java.util.Map;

/**
 * author:jiuyuanle
 * create:2023-09-21 12:44
 */
public class Work1_SumOfTwoNumber {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int [] a=new int[]{0,4,3,0};
        int[] ints = solution.twoSum(a, 0);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }



}

/*给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出
和为目标值 target  的那 两个 整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 */

/*
方法一：暴力破解
空间复杂度O(1)
时间复杂度O(n^2)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j]==target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}

/*
方法二：哈希表
空间复杂度O(n)
时间复杂度O(n)
 */
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int len= nums.length;
        //设置好长度可以有效提高因为底层数组扩展造成的效率损失
        Map<Integer,Integer> map=new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            //判断map里面是否含有target-nums[i]
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            //没有，则把当前的数组的值和下标放到哈希表中
            map.put(nums[i],i);
        }
        //没有找到，抛出异常
        throw new IllegalArgumentException("No two sum solution");
    }
}
