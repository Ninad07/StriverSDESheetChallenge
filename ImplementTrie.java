public class Trie {
    private static class TrieNode {
        TrieNode[] arr;
        boolean isEndOfWord;
        public TrieNode() {
            arr = new TrieNode[26];
        }
    }
    private static TrieNode root;
    //Initialize your data structure here

    Trie() {
        root = new TrieNode();
    }


    //Inserts a word into the trie

    public static void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if(node.arr[character - 'a'] == null) node.arr[character - 'a'] = new TrieNode();
            node = node.arr[character - 'a'];
        }
        
        node.isEndOfWord = true;
    }


    //Returns if the word is in the trie

    public static boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if(node.arr[character - 'a'] == null) return false;
            node = node.arr[character - 'a'];
        }
        return node.isEndOfWord;
    }

    
    //Returns if there is any word in the trie that starts with the given prefix

    public static boolean startsWith(String prefix) {
         TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++) {
            char character = prefix.charAt(i);
            if(node.arr[character - 'a'] == null) return false;
            node = node.arr[character - 'a'];
        }
        return true;
    }
}
