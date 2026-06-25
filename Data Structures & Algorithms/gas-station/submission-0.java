class Solution {
    public int ispossible(int []gas,int[]cost,int index,int len,int Gas){
        Gas+=gas[index]-cost[index];
        if(len==gas.length)
        {
            return index;
        }
        if(Gas<0)
        {
            return -1;
        }
        return ispossible(gas,cost,(index+1)%gas.length,len+1,Gas);//need to make it circular i%n
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0;i<gas.length;i++)
        {
            int x=ispossible(gas,cost,i,0,0);
            if(x!=-1){
                return x;
            }
        }
        return -1;
    }
}
