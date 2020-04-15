package 每日一题;

/**
 * @author liqicong@myhexin.com
 * @date 2020/4/11 10:00
 */
public class Leetcode887 {
    /**
     * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
     *
     * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
     *
     * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
     *
     * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
     *
     * 你的目标是确切地知道 F 的值是多少。
     *
     * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
     *
     *  
     *
     * 示例 1：
     *
     * 输入：K = 1, N = 2
     * 输出：2
     * 解释：
     * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
     * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
     * 如果它没碎，那么我们肯定知道 F = 2 。
     * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
     * 示例 2：
     *
     * 输入：K = 2, N = 6
     * 输出：3
     *
     * 示例 3：
     *
     * 输入：K = 3, N = 14
     * 输出：4
     *  
     *
     * 提示：
     *
     * 1 <= K <= 100
     * 1 <= N <= 10000
     *
     * 链接：https://leetcode-cn.com/problems/super-egg-drop
     * @param K
     * @param N
     * @return
     */
    Integer[][] dp=null;
    public int superEggDrop(int K, int N) {
        int floors=N;
        int eggs=K;
        dp=new Integer[floors+1][eggs+1];
        return helper(floors,eggs);
    }
    public int helper(int f,int eg){
        if(eg==1){
            return f;
        }
        if(f==0){
            return 0;
        }
        if(dp[f][eg]!=null){
            return dp[f][eg];
        }
        int tmp=Integer.MAX_VALUE;
        int lo=1;int high=f;
        while(lo<=high){
            int mid=(lo+high)/2;
            int noBreak=helper(f-mid,eg);
            int breaked=helper(mid-1,eg-1);
            if(noBreak>breaked){
                lo=mid+1;
                tmp=Math.min(tmp,noBreak+1);
            }else{
                high=mid-1;
                tmp=Math.min(tmp,breaked+1);
            }
        }
//        for(int i=1;i<=f;i++){
//            int noBreak=helper(f-i,eg);
//            int breaked=helper(i-1,eg-1);
//            tmp=Math.min(tmp,Math.max(noBreak,breaked)+1);
//        }
        dp[f][eg]=tmp;
        return tmp;
    }
    public static void main(String[] args)throws Exception{
        System.out.println(System.currentTimeMillis());
        System.out.println(new Leetcode887().superEggDrop(3,14));
        Thread.sleep(5000);
        System.out.println(System.currentTimeMillis());
    }
}