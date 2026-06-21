class PrefixTree {

    TrieNode root;

    class TrieNode{
        char c;
        boolean isover=false;
        TrieNode children[];

        TrieNode()
        {
            children = new TrieNode[26];
        }
        
        TrieNode(char c,boolean isover)
        {
            this.c=c;
            this.isover=isover;
            children = new TrieNode[26];
        }

    }
    public PrefixTree() {
        root=new TrieNode(); 
    }

    public void insert(String word) {
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
        for(char ch:word.toCharArray())
        {
            if(curr.children[ch-'a']==null)
            {
                return false;
            }
            curr=curr.children[ch-'a'];
        }
        if(curr.isover==false)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(char ch:prefix.toCharArray())
        {
            if(curr.children[ch-'a']==null)
            {
                return false;
            }
            curr=curr.children[ch-'a'];
        }
        return true;

    }
}
