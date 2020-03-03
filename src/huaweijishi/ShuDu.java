package huaweijishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/2 11:25
 */
public class ShuDu {
    /**
     * 题目描述
     * 问题描述：数独。玩家需要根据9X9盘面上的已知数字，推算出所有剩余空格的数字，
     * 并且满足每一行、每一列、每一个粗线宫内的数字均含1-9，并且不重复。
     * 输入：
     * 包含已知数字的9X9盘面数组[空缺位以数字0表示]
     * 输出：
     * 完整的9X9盘面数组
     * <p>
     * 输入描述:
     * 包含已知数字的9X9盘面数组[空缺位以数字0表示]
     * <p>
     * 输出描述:
     * 完整的9X9盘面数组
     */
    public void shudu() {
        Scanner sc = new Scanner(System.in);
        //回溯啊
        int[][] matrix = new int[9][9];
        while (sc.hasNext()) {

            for (int i = 0; i < 9; i++) {
                String[] s = sc.nextLine().split(" ");
                for (int j = 0; j < 9; j++) {
                    matrix[i][j] = Integer.parseInt(s[j]);
                }
            }
        }
        //matrix初始化完成
        helper(matrix,0,0);

    }

    public void helper(int[][] shudu, int i, int j) {
        //满足三个条件
        //需要满足这个点的横竖和3x3格子里都是1~9
        //一开始没填完的时候不判断呀，如果横竖或者3x3格子里有0，就先不判断，等到全部填完再判断
        //没填完就开始判断不是无意义吗
        //从0，0开始向matrix里面放数值，用一个辅助数组存放是否修改过的标记
        //如果全部填完，或者不符合数独条件，则直接回溯上一步
        //全放完了才去检测是否满足数独条件
        if (i==8&&j==8) {
            //输出数独信息
            return;
        }
        if (shudu[i][j] != 0) {
            if(j<8){helper(shudu,i,j+1);}
            if(j==8){helper(shudu,i+1,j);}
        }
        //执行数字1~9的放置
        for (int num = 1; num <= 9; num++) {
            shudu[i][j] = num;
            //判断这点是否满足数独条件
            if (!check(shudu, i, j)) {
                shudu[i][j] = 0;
            }
            helper(shudu,i,j+1);
            shudu[i][j] = 0;
        }
    }

    public boolean check(int[][] shudu, int row, int col) {
        int[] temp = shudu[row];
        Arrays.sort(temp);
        for (int j = 0; j < 9; j++) {
            if (temp[j] != j + 1) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            temp[i] = shudu[i][col];
        }
        Arrays.sort(temp);
        for (int j = 0; j < 9; j++) {
            if (temp[j] != j + 1) {
                return false;
            }
        }
        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                temp[(i - startRow) * 3 + (j - startCol)] = shudu[i][j];
            }
        }
        Arrays.sort(temp);
        for (int j = 0; j < 9; j++) {
            if (temp[j] != j + 1) {
                return false;
            }
        }
        return true;
    }
}
