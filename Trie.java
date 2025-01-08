class TrieNode{
    TrieNode[] next;
    boolean wordEnd = false;
    TrieNode(){
        next = new TrieNode[26];
        this.wordEnd = false;
    }
}

class Trie {
    TrieNode root;
    boolean wordEnd;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;

        for(int i=0;i<word.length();i++){
            int currChar = word.charAt(i)-'a';
            if(curr.next[currChar]!=null){
                curr = curr.next[currChar];
            }
            else{
                curr.next[currChar] = new TrieNode();
                curr = curr.next[currChar];
            }
        }
        curr.wordEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            int currChar = word.charAt(i)-'a';
            if(curr.next[currChar]!=null){
                curr = curr.next[currChar];
            }
            else{
                return false;
            }
        }
        return curr.wordEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++){
            int currChar = prefix.charAt(i)-'a';
            if(curr.next[currChar]!=null){
                curr = curr.next[currChar];
            }
            else{
                return false;
            }
        }
        return true;
    }
}