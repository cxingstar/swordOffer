package groundtrue.chapters1;

public class o5 {
// 单词长度的最大乘积 哈希表计算
    public int maxProduct(String[] words){
        int result = 0;
        boolean[][] flags = new boolean[words.length][26];
        for(int i = 0;i < words.length;i++){
            for (int j = 0;j < words[i].length();j++){
                flags[i][words[i].charAt(j)-'a'] = true;
            }
        }
        for(int i = 0; i < words.length; i++)
            for(int j = 0; j < words.length;j++){
                int k = 0;
                for(;k < 26;k++)
                    if (flags[i][k] && flags[j][k])
                        break;
                if(k == 26)
                    result = Math.max(result, words[i].length()*words[j].length());
            }
        return result;
    }


    public int maxProduct1(String[] words){
        int result = 0;
        int[] flags = new int[words.length];
        for(int i = 0;i < words.length;i++)
            for (char ch: words[i].toCharArray())
            flags[i] |= 1 << (ch-'a');
        for(int i = 0; i < words.length; i++)
            for(int j = i+1; j < words.length;j++){
                if((flags[i] & flags[j]) == 0)
                    result = Math.max(result, words[i].length()*words[j].length());
            }
        return result;
    }

}
