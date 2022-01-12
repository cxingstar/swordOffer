package groundtrue.chapters10;

public class o66 {
    class MapSum {
        class TrieNode{
            TrieNode[] children;
            boolean isWord;
            int value;
            public TrieNode(){
                children = new TrieNode[26];
            }
        }
        TrieNode root;
        /** Initialize your data structure here. */
        public MapSum() {
            root  = new TrieNode();
        }

        public void insert(String key, int val) {
            TrieNode node = root;
            for(char ch : key.toCharArray()){
                if(node.children[ch - 'a'] == null)
                    node.children[ch - 'a'] = new TrieNode();
                node = node.children[ch - 'a'];
            }
            node.isWord = true;
            node.value = val;
        }

        public int sum(String prefix) {
            TrieNode node = root;
            for(char ch : prefix.toCharArray()){

                if(node.children[ch - 'a'] != null)
                    node = node.children[ch - 'a'];
                else
                    return 0;
            }
            return getSum(node);
        }

        private int getSum(TrieNode root){
            if(root == null)
                return 0;
            int result = root.value;
            for(TrieNode each : root.children){
                result += getSum(each);
            }
            return result;
        }
    }
}
