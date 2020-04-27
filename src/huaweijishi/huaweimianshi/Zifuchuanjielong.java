package huaweijishi.huaweimianshi;

import java.util.Arrays;

/**
 * @author liqicong@myhexin.com
 * @date 2020/4/15 19:58
 */
public class Zifuchuanjielong {
    /**
     *
     * @param words 字符串数组
     * @param start 以start这个字符为开头的作为龙头来接龙
     *   每个字符串可以使用最多2次，包含关系的不能连接，相同字符串不看作包含
     * @return
     */
    int[] enable;
    int max=Integer.MIN_VALUE;
    String[] words;
    public int Solution(String[] words,String start){
        this.words=words;
        enable=new int[words.length];
        Arrays.fill(enable,2);
        for(int i=0;i<words.length;i++){
            if(words[i].startsWith(start)){
                enable[i]=1;
                helper(words[i]);
            }
        }






        return 1;
    }

    public void helper(String startWord){
        //如果没有字符串可以接了，就return，判断最大长度和还原enable数组
        if(!exists(startWord)){
            max=Math.max(max,startWord.length());
            Arrays.fill(enable,2);
            return;
        }
        for(int i=0;i<words.length;i++){

        }

    }


    public boolean exists(String startWord){

        return false;
    }

    public boolean checkCommon(String startWord,int index){
        if(enable[index]==0)return false;
        if(startWord.equals(words[index]))return true;
        String word=words[index];
        //找startWord与word的公共之处
        for(int i=word.length()-1;i>=0;i--){
            String part=word.substring(i);
            if(word.startsWith(part)){
                if(i!=0){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }
}
