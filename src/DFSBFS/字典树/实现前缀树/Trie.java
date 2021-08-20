package DFSBFS.字典树.实现前缀树;
class Trie {
    //居然一遍过 震撼
    boolean isEnd;
    Trie[] next;
    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie nowTrie = this;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if (nowTrie.next[ch] != null) {
                nowTrie = nowTrie.next[ch];
            }
            else {
                Trie update = new Trie();
                nowTrie.next[ch] = update;
                nowTrie = nowTrie.next[ch];
            }
            if (i == word.length() - 1) {
                nowTrie.isEnd = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie nowTrie = this;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if (nowTrie.next[ch] != null) {
                nowTrie = nowTrie.next[ch];
            }
            else return false;
            if (i == word.length() - 1) {
                return nowTrie.isEnd;
            }
        }
        return true;
    }
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie nowTrie = this;
        for (int i = 0; i < prefix.length(); i++) {
            int ch = prefix.charAt(i) - 'a';
            if (nowTrie.next[ch] != null) {
                nowTrie = nowTrie.next[ch];
            }
            else return false;
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
