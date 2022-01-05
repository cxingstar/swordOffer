package groundtrue.chapters5;

public class o34 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderArray = new int[26];
        int i = 0;
        for (char ch:order.toCharArray())
            orderArray[ch - 'a'] = i++;
        for (int j = 0; j < words.length - 1;j++){
            if(!isSorted(words[j],words[j+1],orderArray))
                return false;
        }
        return true;
    }
    private boolean isSorted(String word1,String word2, int[] order){
        for(int i = 0;i < word1.length() && i < word2.length(); i++){
            if(order[word1.charAt(i) - 'a'] > order[word2.charAt(i) - 'a'])
                return false;
            if(order[word1.charAt(i) - 'a'] < order[word2.charAt(i) - 'a'])
                return true;
        }
        return word1.length() <= word2.length();

    }
}
