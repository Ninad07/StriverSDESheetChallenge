public class Trie {
    private static class TrieNode {
        TrieNode[] arr;
        boolean isEndOfWord;
        int count;
        public TrieNode() {
            arr = new TrieNode[26];
            count = 0;
        }
    }
    private static TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if(node.arr[character - 'a'] == null) node.arr[character - 'a'] = new TrieNode();
            node = node.arr[character - 'a'];
            node.count++;
        }
        
        node.isEndOfWord = true;
    }

    public int countWordsEqualTo(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if(node.arr[character - 'a'] == null) return 0;
            node = node.arr[character - 'a'];
        }
        return node.isEndOfWord ? node.count : 0;
    }

    public int countWordsStartingWith(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if(node.arr[character - 'a'] == null) return 0;
            node = node.arr[character - 'a'];
        }
        return node.count;
    }

    public void erase(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if(node.arr[character - 'a'].count == 1) {
                node.arr[character - 'a'] = null;
                return;
            }
            node = node.arr[character - 'a'];
            node.count--;
        }
    }

}
