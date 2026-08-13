class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>stack=new Stack<>();
        for(int x:asteroids){
            boolean equal=false;
            if(!stack.isEmpty()){
                while(!stack.isEmpty()&&(stack.peek()>0&&x<0)){
                    if(Math.abs(stack.peek())<Math.abs(x)){
                        stack.pop();
                    }
                    else if(Math.abs(stack.peek())==Math.abs(x)){
                        stack.pop();
                        equal=true;
                        break;
                    }
                    else{
                        equal=true;
                        break;
                    }
                }
                if(!equal){
                    stack.push(x);
                }
                
            }
            else{
                stack.push(x);
            }
            
        }
        int[]ans=new int[stack.size()];
        int i=0;
        while(!stack.isEmpty()){
            ans[i]=stack.pop();
            i++;
        }
        int[] reversed = new int[ans.length];

        for (int j = 0; j < ans.length; j++) {
            reversed[j] = ans[ans.length - 1 - j];
        }

        return reversed;
    }
}