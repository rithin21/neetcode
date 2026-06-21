class WordDictionary {
    TrieNode root;

    class TrieNode{
        char c;
        boolean isover;
        TrieNode []children;

        TrieNode()
        {
            children=new TrieNode[26];
        }
        TrieNode(char c,boolean isover)
        {
            this.c=c;
            this.isover=isover;
            children=new TrieNode[26];
        }
    }

    public WordDictionary() {
        root=new TrieNode();

    }

    public void addWord(String word) {
        TrieNode curr=root;
        for(char ch:word.toCharArray())
        {
            if(curr.children[ch-'a']==null)
            {
                curr.children[ch-'a']=new TrieNode(ch,false);
            }
            curr=curr.children[ch-'a'];
        }
        curr.isover=true;
    }

    public boolean search(String word) {
        TrieNode curr=root;
        return dfs(curr,word,0);
        
    }

    private boolean dfs(TrieNode curr, String word, int index)
    {
        if(index == word.length())
        {
            return curr.isover;
        }

        char ch = word.charAt(index);

        if(ch == '.')
        {
            for(TrieNode child : curr.children)
            {
                if(child != null &&
                dfs(child, word, index + 1))
                {
                    return true;
                }
            }

            return false;
        }

        TrieNode next = curr.children[ch - 'a'];

        if(next == null)
        {
            return false;
        }

        return dfs(next, word, index + 1);
    }
}
