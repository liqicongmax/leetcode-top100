package 每日一题;

import java.util.Arrays;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/11 9:45
 */
public class Leetcode1013 {
    /**
     * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
     * <p>
     * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输出：[0,2,1,-6,6,-7,9,1,2,0,1]
     * 输出：true
     * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
     * 示例 2：
     * <p>
     * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
     * 输出：false
     * 示例 3：
     * <p>
     * 输入：[3,3,6,5,-2,2,5,1,-9,4]
     * 输出：true
     * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
     *  
     * <p>
     * 提示：
     * <p>
     * 3 <= A.length <= 50000
     * -10^4 <= A[i] <= 10^4
     * <p>
     * 链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
     *
     * @param A
     * @return
     */
    public boolean canThreePartsEqualSum(int[] A) {
        if (A.length<3) {
            return false;
        }
        int total = Arrays.stream(A).sum();
        if (total % 3 != 0) {
            return false;
        }
        int part = total / 3;
        int start = 0;
        int sumstart = A[0];
        int end = A.length - 1;
        int sumend = A[A.length-1];
        while (start < end ) {
            if(sumstart!=part) {
                sumstart += A[++start];
            }
            if(sumend!=part) {
                sumend += A[--end];
            }
            if(sumend==sumstart&&sumend==part){
                break;
            }
        }
        return sumend==part&&sumstart==part&&end-start>1;
    }
    public static void main(String[] args){
        int[] arr=new int[]{3,3,6,5,-2,2,5,1,-9,4};
        System.out.println(new Leetcode1013().canThreePartsEqualSum(arr));
    }
}
