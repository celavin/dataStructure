package leetCode;

import java.util.Arrays;
import java.util.HashMap;

/*给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
注意：
对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
如果 s 中存在这样的子串，我们保证它是唯一的答案*/

//历时35分钟总算解决了
public class leetCode76 {
    static String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }

        HashMap<Character,Integer> needs = new HashMap<>();
        //先将t的字符全部存入hashet
        for (char c : t.toCharArray()) {
             needs.put(c, needs.getOrDefault(c,0)+1);
        }
        HashMap<Character,Integer> window = new HashMap<>();
        int count = 0;
        //接下来找最小子串
        //1.保证包含全部字符
        //如果count中有这个key,就-1,如果小于0,则不满足,不满足该怎么做?
        //没有这个key就无视
        //但是我如何确认是否包含全部字符呢
        //2.保证最短
        //滑动窗口实现,for循环
        int minlength =s.length()+1;

        int mini = 0,minj=s.length()-1;
        int i = 0;
        char c;
        char[] charArray = s.toCharArray();
        for (int j = 0; j < charArray.length; j++) {
            c = charArray[j];
            if(needs.containsKey(c)){
                window.put(c, window.getOrDefault(c,0)+1);
                if(needs.get(c).equals(window.get(c))){
                    count+=1;
                }
            }
            while(count == needs.size()){//满足条件,开始缩减,i向右移动
                if(minlength>j-i+1){
                    minlength = j-i+1;
                    mini=i;
                    minj=j;
                }

                c = charArray[i];
                if(window.containsKey(c)){
                    window.put(c,window.get(c)-1);
                    if(window.get(c) < needs.get(c)){
                        count -= 1;
                    }
                }
                i++;
            }
        }
        if(minlength ==s.length()+1){
            return "";
        }else {
            char[] slice = Arrays.copyOfRange(charArray, mini, minj + 1);
            return new String(slice);
        }
    }
}
