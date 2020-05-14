package may.fourteen;

import java.util.HashMap;
import java.util.Map;

class Trie {

    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;
        
        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    private final TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
        	char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null) {
            	return false;
            }
            current = node;
        }
        if(current.endOfWord)
        	return current.endOfWord;
        else 
        	return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode current = root;
        for(int i = 0; i < prefix.length(); i++) {
        	char ch = prefix.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null) {
            	return false;
            }
            current = node;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

public class TrieTest {
	public static void main(String[] args) {
		Trie obj = new Trie();
		String word = "apple";
		String prefix = "app";
		obj.insert(word);
		boolean param_2 = obj.search(word);
		boolean param_3 = obj.startsWith(prefix);
		boolean param_4 = obj.search(prefix);
		obj.insert(prefix);
		boolean param_5 = obj.search(prefix);
		System.out.println(param_2+" | "+param_3+" | "+param_4+" | "+param_5);
	}
}