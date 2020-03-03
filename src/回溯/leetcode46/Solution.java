package 回溯.leetcode46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/2 16:59
 */
public class Solution {
    /**
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     *
     * 示例:
     *
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     *
     * 链接：https://leetcode-cn.com/problems/permutations
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length==0){
            return res;
        }
        List<Integer> ints=new ArrayList<>();
        helper(res,nums,new boolean[nums.length],ints);
        return res;
    }

    public void helper(List<List<Integer>> res,int[] nums,boolean[] visited,List<Integer> ints){
        if(ints.size()==nums.length){
            res.add(new ArrayList<>(ints));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i]){
                continue;
            }
            ints.add(nums[i]);
            visited[i]=true;
            helper(res,nums,visited,ints);
            //这轮操作结束了，return之后回溯到上一步的操作
            ints.remove(Integer.valueOf(nums[i]));
            visited[i]=false;
        }
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(new Solution().permute(new int[]{1,2,3}).toArray()));
    }
}
