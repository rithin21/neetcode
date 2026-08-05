class Solution {
    public int appendCharacters(String s, String t) {
        int last_position=0;
        int break_position=0;
        boolean found=false;
        for(int i=0;i<t.length();i++){
            char curr_char=t.charAt(i);
            found=false;
            for(int j=last_position;j<s.length();j++){
                if(s.charAt(j)==curr_char){
                    last_position=j+1;
                    found=true;
                    break;
                }
            }
            if(found==false){
                break_position=i;
                break;
            }
            
        }
        if(found==true){
            return 0;
        }
        return t.length()-break_position;
    }
}