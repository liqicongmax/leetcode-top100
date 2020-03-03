package huaweijishi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/2 9:30
 */
public class Jisuan24Dian {
    /**
     * 计算24点是一种扑克牌益智游戏，随机抽出4张扑克牌，通过加(+)，减(-)，乘(*), 除(/)四种运算法则计算得到整数24，
     * 本问题中，扑克牌通过如下字符或者字符串表示，其中，小写joker表示小王，大写JOKER表示大王：
     *
     * 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
     *
     * 本程序要求实现：输入4张牌，输出一个算式，算式的结果为24点。
     *
     * 详细说明：
     *
     * 1.运算只考虑加减乘除运算，没有阶乘等特殊运算符号，友情提醒，整数除法要当心，输出的除号只能表示int类型之间的相除，结果向下取整；
     * 2.牌面2~10对应的权值为2~10, J、Q、K、A权值分别为为11、12、13、1；
     * 3.输入4张牌为字符串形式，以一个空格隔开，首尾无空格；如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；
     * 4.输出的算式格式为4张牌通过加减乘除四个运算符相连，中间无空格，4张牌出现顺序任意，只要结果正确；
     * 5.输出算式的运算顺序从左至右，不包含括号，如1+2+3*4的结果为24
     * 6.如果存在多种算式都能计算得出24，只需输出一种即可，如果无法得出24，则输出“NONE”表示无解。
     */
    HashMap<String,Integer> map=new HashMap<>();
    Flag flag1=new Flag();
    Flag flag2=new Flag();
    Flag flag3=new Flag();
    public String solution(){
        Scanner sc=new Scanner(System.in);
        String keys=sc.nextLine();
        String[] words=keys.split(" ");
        System.out.println(Arrays.toString(words));

        map.put("A",1);
        for(int i=2;i<=10;i++){
            map.put(String.valueOf(i),i);
        }
        map.put("J",11);
        map.put("Q",12);
        map.put("K",13);
        for(String s:words){
            if("JOKER".equals(s)||"joker".equals(s)){
                return "ERROR";
            }
        }
        for(int a=0;a<4;a++){
            int vala=map.get(words[a]);
            for(int b=0;b<4;b++){
                if(map.get(words[b])==vala)continue;
                int valb=map.get(words[b]);
                for(int c=0;c<4;c++){
                    int valc=map.get(words[c]);
                    if(valc==vala||valc==valb)continue;
                    for(int d=0;d<4;d++){
                        int vald=map.get(words[d]);
                        if(vald==vala||vald==valb||vald==valc)continue;
                        if(fourWord(vala,valb,valc,vald,flag1,flag2,flag3)){
                            return "get";
                        }
                    }
                }
            }
        }



        return "NONE";
    }
    //把4个数字每个顺序都试一遍


    public boolean twoWord(int a,int b,Flag flag){
        if(a+b==24){ flag.flag="+";return true; }
        if(a-b==24){ flag.flag="-";return true; }
        if(a*b==24){ flag.flag="*";return true; }
        if(b!=0&&a%b==0&&a/b==24){ flag.flag="/";return true; }
        return false;
    }

    public boolean threeWord(int a,int b,int c,Flag tmp1,Flag tmp2){
        if(twoWord(a+b,c,tmp2)){tmp1.flag="+";return true;}
        if(twoWord(a-b,c,tmp2)){tmp1.flag="-";return true;}
        if(twoWord(a*b,c,tmp2)){tmp1.flag="*";return true;}
        if(b!=0&&a%b==0&&twoWord(a/b,c,tmp2)){tmp1.flag="/";return true;}
        return false;
    }

    public boolean fourWord(int a,int b,int c,int d,Flag tmp1,Flag tmp2,Flag tmp3){
        if(threeWord(a+b,c,d,tmp2,tmp3)){
            tmp1.flag="+";
            System.out.println(a+""+b+""+c+""+d+""+tmp1.flag+tmp2.flag+tmp3.flag);
            return true;}
        if(threeWord(a-b,c,d,tmp2,tmp3)){tmp1.flag="-";System.out.println(a+""+b+""+c+""+d+""+tmp1.flag+tmp2.flag+tmp3.flag);return true;}
        if(threeWord(a*b,c,d,tmp2,tmp3)){tmp1.flag="*";System.out.println(a+""+b+""+c+""+d+""+tmp1.flag+tmp2.flag+tmp3.flag);return true;}
        if(b!=0&&a%b==0&&threeWord(a/b,c,d,tmp2,tmp3)){tmp1.flag="/";System.out.println(a+""+b+""+c+""+d+""+tmp1.flag+tmp2.flag+tmp3.flag);return true;}
        return false;
    }

    public static void main(String[] args){
        Jisuan24Dian j=new Jisuan24Dian();
        System.out.println(j.solution());
    }
}
class Flag {
    public String flag;
}