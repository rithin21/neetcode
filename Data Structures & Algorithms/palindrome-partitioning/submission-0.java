class Solution {
    List<List<String>>ans=new ArrayList<>();
    public List<List<String>> partition(String s) {

        backtrack(0,s,new ArrayList<String>());
        return ans;   
    }

    public boolean check_palindrome(int l,int r,String s)
    {
        while(l<=r)
        {
            if(s.charAt(l)==s.charAt(r)){
                l++;
                r--;
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    public void backtrack(int index,String s,ArrayList<String>curr_list){
        if(index==s.length()){
            ans.add(new ArrayList<>(curr_list));
            return;
        }
        for(int r=index;r<s.length();r++)
        {
            if(check_palindrome(index,r,s)){
                curr_list.add(s.substring(index,r+1));
                backtrack(r+1,s,curr_list);
                curr_list.remove(curr_list.size()-1);
            }
        }
    }
}
