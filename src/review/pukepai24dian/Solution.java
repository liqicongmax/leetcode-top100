package review.pukepai24dian;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/5 9:40
 */
public class Solution {
    HashMap<String,Integer> map=new HashMap<>();
    Flag flag1=new Flag();
    Flag flag2=new Flag();
    Flag flag3=new Flag();
    public String solution(){
        Scanner sc=new Scanner(System.in);
        String[] cards=sc.nextLine().split(" ");
        System.out.println(Arrays.toString(cards));
        map.put("A",1);
        for(int i=2;i<=10;i++){
            map.put(String.valueOf(i),i);
        }
        map.put("J",11);
        map.put("Q",12);
        map.put("K",13);
        for(String s:cards){
            if("JOKER".equals(s)||"joker".equals(s)){
                return "ERROR";
            }
        }
        for(int a=0;a<4;a++){
            int vala=map.get(cards[a]);
            for(int b=0;b<4;b++){
                if(map.get(cards[b])==vala)continue;
                int valb=map.get(cards[b]);
                for(int c=0;c<4;c++){
                    int valc=map.get(cards[c]);
                    if(valc==vala||valc==valb)continue;
                    for(int d=0;d<4;d++){
                        int vald=map.get(cards[d]);
                        if(vald==vala||vald==valb||vald==valc)continue;
                        if(get(vala,valb,valc,vald,flag1,flag2,flag3)){
                            return "get";
                        }
                    }
                }
            }
        }
        return "NONE";
    }

    public boolean get(int a,int b,Flag flag){
        if(a+b==24){flag.flag="+";return true;}
        if(a-b==24){flag.flag="-";return true;}
        if(a*b==24){flag.flag="*";return true;}
        if(b!=0&&a%b==0&&a/b==24){flag.flag="/";return true;}
        return false;
    }

    public boolean get(int a,int b,int c,Flag flag1,Flag flag2){
        if(get(a+b,c,flag2)){flag1.flag="+";return true;}
        if(get(a-b,c,flag2)){flag1.flag="-";return true;}
        if(get(a*b,c,flag2)){flag1.flag="*";return true;}
        if(b!=0&&a%b==0&&get(a/b,c,flag2)){flag1.flag="/";return true;}
        return false;
    }

    public boolean get(int a,int b,int c,int d,Flag flag1,Flag flag2,Flag flag3){
        if(get(a+b,c,d,flag2,flag3)){flag1.flag="+";System.out.println(a+""+b+""+c+""+d+""+flag1.flag+flag2.flag+flag3.flag);return true;}
        if(get(a-b,c,d,flag2,flag3)){flag1.flag="-";System.out.println(a+""+b+""+c+""+d+""+flag1.flag+flag2.flag+flag3.flag);return true;}
        if(get(a*b,c,d,flag2,flag3)){flag1.flag="*";System.out.println(a+""+b+""+c+""+d+""+flag1.flag+flag2.flag+flag3.flag);return true;}
        if(b!=0&&a%b==0&&get(a/b,c,d,flag2,flag3)){flag1.flag="/";System.out.println(a+""+b+""+c+""+d+""+flag1.flag+flag2.flag+flag3.flag);return true;}
        return false;
    }
    public static void main(String[] args){
        System.out.println(new Solution().solution());
    }
}
class Flag{
    String flag;
}