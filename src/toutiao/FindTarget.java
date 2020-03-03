package toutiao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/3 20:05
 */
public class FindTarget {
    public List<String> findTarget(int[] nums,int target){
        boolean[] visited=new boolean[nums.length];
        List<String> res=new ArrayList<>();
        helper(res,target,nums,0,"",visited);
        return res;
    }

    public void helper(List<String> res,int target,int[] nums,int step,String word,boolean[] visited){
        if(step==2){
            if(target==0){
                res.add(word);
            }
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i])return;
            visited[i]=true;
            helper(res,target-nums[i],nums,step+1,word+nums[i],visited);
            visited[i]=false;
        }
    }
    public static void main(String[] args){
        int[] arr=new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(new FindTarget().findTarget(arr,6).toArray()));
    }
}
