package groundtrue.chapters10;

import java.util.List;

public class o63 {
    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    public TrieNode buildTrie(List<String> dictionary){
        TrieNode root = new TrieNode();
        for(String word : dictionary){
            TrieNode node = root;
            for(char ch : word.toCharArray()){
                if(node.children[ch - 'a'] == null)
                    node.children[ch - 'a'] = new TrieNode();
                node = node.children[ch - 'a'];
            }
            node.isWord = true;
        }
        return root;
    }

    public String findPrefix(TrieNode root,String word){
        TrieNode node = root;
        StringBuilder builder = new StringBuilder();
        for(char ch : word.toCharArray()){
            if(node.isWord || node.children[ch - 'a'] == null)
                break;
            builder.append(ch);
            node = node.children[ch -'a'];
        }
        return node.isWord ? builder.toString() : "";
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        TrieNode root = buildTrie(dictionary);
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            String prefix = findPrefix(root , words[i]);
            if(!prefix.isEmpty())
                words[i] = prefix;
        }
        return String.join(" ",words);
    }
}
