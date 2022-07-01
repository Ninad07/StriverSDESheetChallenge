
class Solution {
  private static class TrieNode {
      TrieNode[] arr;
      boolean isEndOfWord;
      String word;
      TrieNode() {
          arr = new TrieNode[26];
          word = "";
      }
  }
  private static TrieNode root;  
  
  public static String completeString(int n, String[] a) {
       root = new TrieNode();
       for(String word : a) insert(word);
         
       TrieNode node = root;  
       root.isEndOfWord = true;
       String max = getCompleteString(node);      
      return max.length() == 0 ? "None" : max;
  }
    
  private static String getCompleteString(TrieNode node) {
      if(!node.isEndOfWord) return "";
      String max = "";
      for(int i = 0; i < 26; i++) {
          if(node.arr[i] != null) {
              String curr = getCompleteString(node.arr[i]);
              if(curr.length() > max.length()) {
                  max = curr;
              } else if(curr.length() == max.length() && curr.compareTo(max) < 0) {
                  max = curr;
              }
          }
      }
      if(node.isEndOfWord) {
          String curr = node.word;
          if(curr.length() > max.length()) {
                  max = curr;
              } else if(curr.length() == max.length() && curr.compareTo(max) < 0) {
                  max = curr;
              }
      }
      return max;
  }
    
  private static void insert(String string) {
      TrieNode node = root;
      for(char character : string.toCharArray()) {
          if(node.arr[character - 'a'] == null) node.arr[character - 'a'] = new TrieNode();
          node = node.arr[character - 'a'];
      }
      node.isEndOfWord = true;
      node.word = string;
  }
}
