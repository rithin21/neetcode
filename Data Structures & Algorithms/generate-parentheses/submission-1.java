class Solution {
    List<String>ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        String s=new String();
        backtrack(0,0,n,s);
        return ans;   
    }

    public void backtrack(int open,int close,int n,String s){
        if(s.length()==2*n)
        {
            ans.add(new String(s));
            return;
        }
        if(open<n)
        {
            backtrack(open+1,close,n,s+"(");
        }
        if(close<open)
        {
            backtrack(open,close+1,n,s+=")");
        }
    }
}
