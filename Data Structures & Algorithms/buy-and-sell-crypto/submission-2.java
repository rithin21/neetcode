class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit=0;
        int minvalue=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++)
        {
            minvalue=Math.min(minvalue,prices[i]);
            maxprofit=Math.max(maxprofit,prices[i]-minvalue);
        }
        return maxprofit;
    }
}
