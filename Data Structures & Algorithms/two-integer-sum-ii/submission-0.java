class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start=0;
        int end=numbers.length-1;
        int indices[]=new int[2];
        while(start<end)
        {
            int cursum=numbers[start]+numbers[end];
            if(cursum<target)
            {
                start++;
            }
            else if(cursum>target)
            {
                end--;
            }
            else if(cursum==target)
            {
                indices[0]=start+1;
                indices[1]=end+1;
                return indices;
            }
        }
        return indices;


        
    }
}
