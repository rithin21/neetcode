class Solution {
    public String longestCommonPrefix(String[] strs) {
        String match=strs[0];
        int n=strs.length;
        for(int i=1;i<n;i++){
            String curr=strs[i];
            int j=0;
            for(j=0;j<match.length();j++){
                if(j>curr.length()-1||curr.charAt(j)!=match.charAt(j)){
                    break;
                }
            }
            if(j==0){
                match="";
            }
            else{
                match=match.substring(0,j);
            }  
        }
        return match;
    }
}