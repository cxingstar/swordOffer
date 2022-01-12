package groundtrue.chapters10;

public class o64 {

    class MagicDictionary {
        class TrieNode{
            TrieNode[] children;
            boolean isWord;
            public TrieNode(){
                children = new TrieNode[26];
            }
        }
        TrieNode root;
        /** Initialize your data structure here. */
        public MagicDictionary() {
            root = new TrieNode();
        }

        public void buildDict(String[] dictionary) {
            for(String word : dictionary){
                TrieNode node = root;
                for(char ch : word.toCharArray()){
                    if(node.children[ch - 'a'] == null){
                        node.children[ch - 'a'] = new TrieNode();
                    }
                    node = node.children[ch - 'a'];
                }
                node.isWord = true;
            }
        }

        public boolean search(String searchWord) {
            return dfs(root,searchWord, 0 , 0);
        }

        public boolean dfs(TrieNode root, String word,int i ,int edit){
            if(root == null)
                return false;
            if(root.isWord && i == word.length() && edit == 1)
                return true;
            if(i < word.length() && edit <= 1){
                boolean found = false;
                for(int j = 0; j < 26 && !found; j++) {
                    int next = j == word.charAt(i) - 'a' ? edit : edit + 1;
                    found = dfs(root.children[j], word, i + 1, next);
                }
                return found;
            }
            return false;
        }
    }
}
