public class Solution {
    private static class TrieNode {
      TrieNode[] arr;
      boolean isEndOfWord;
      TrieNode() {
          arr = new TrieNode[26];
      }
  }
  private static TrieNode root; 
    public static int distinctSubstring(String word) {
        root = new TrieNode();
        for(int i = 0; i < word.length(); i++) {
            for(int j = i; j < word.length(); j++) {
                String substring = word.substring(i, j + 1);
                insert(substring);
            }
        }
        TrieNode node = root;
        return countDistinct(node);
    }
    
    private static int countDistinct(TrieNode node) {
        int count = 0;
        for(int i = 0; i < 26; i++) {
            if(node.arr[i] != null) {
                count += (node.arr[i].isEndOfWord ? 1 : 0) + countDistinct(node.arr[i]);
             }
        }
        
        return count;
    }
    
    private static void insert(String string) {
      TrieNode node = root;
      for(char character : string.toCharArray()) {
          if(node.arr[character - 'a'] == null) node.arr[character - 'a'] = new TrieNode();
          node = node.arr[character - 'a'];
      }
      node.isEndOfWord = true;
  }
}
