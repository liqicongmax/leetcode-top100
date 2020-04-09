package 每日一题;

import java.util.Arrays;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/31 16:21
 */
public class LeetCode912 {
    /**
     * 给你一个整数数组 nums，请你将该数组升序排列。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [5,2,3,1]
     * 输出：[1,2,3,5]
     * 示例 2：
     * <p>
     * 输入：nums = [5,1,1,2,0,0]
     * 输出：[0,0,1,1,2,5]
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 50000
     * -50000 <= nums[i] <= 50000
     * <p>
     * 链接：https://leetcode-cn.com/problems/sort-an-array
     *
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        sort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    public void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    public void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }

        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,2,3,1};
        new LeetCode912().sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
