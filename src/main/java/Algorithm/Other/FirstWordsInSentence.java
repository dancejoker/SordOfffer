package Algorithm.Other;

/**
 * 第一个只出现一次的字符
 * 描述
 * 在一个长为 字符串中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数
 */
public class FirstWordsInSentence {
    public int FirstNotRepeatingChar(String str) {
        int[] array = new int[256];
        for(int i=0;i < str.length();++i){
            array[str.charAt(i)]++;
        }
        for(int i = 0; i< str.length();++i){
            if(array[str.charAt(i)] == 1){
                return i;
            }

        }
        return  -1;
    }
}
