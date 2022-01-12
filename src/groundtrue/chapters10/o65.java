package groundtrue.chapters10;

public class o65 {

    class Solution {
        class TrieNode{
            TrieNode[] children;
            boolean isWord;
            public TrieNode(){
                children = new TrieNode[26];
            }
        }
        public int minimumLengthEncoding(String[] words) {
            for(int i = 0; i < words.length;i++){
                words[i] = reverse(words[i],0,words[i].length()-1);
            }
            TrieNode root = bulidTrie(words);
            int total[] = {0};
            dfs(root,1,total);
            return total[0];
        }
        private TrieNode bulidTrie(String[] words){
            TrieNode root = new TrieNode();
            for(String word : words){
                TrieNode node = root;
                for(char ch : word.toCharArray()){
                    if(node.children[ch - 'a'] == null){
                        node.children[ch - 'a'] = new TrieNode();
                    }
                    node = node.children[ch - 'a'];
                }
                node.isWord = true;
            }
            return root;
        }
        private String reverse(String str, int start, int end){
            char[] res = str.toCharArray();
            for(; start <end; start++,end--){
                char ch = res[start];
                res[start] = res[end];
                res[end] = ch;
            }
            return String.valueOf(res);
        }
        private void dfs(TrieNode root,int length, int[] res){
            boolean isLeaf = true;
            for(int i = 0; i < 26; i++){
                if(root.children[i] != null){
                    isLeaf = false;
                    dfs(root.children[i],length + 1,res);
                }
            }
            if(isLeaf){
                res[0] += length;
            }
        }
    }
}
