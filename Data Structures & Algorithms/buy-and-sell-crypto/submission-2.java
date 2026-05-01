class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length<2||prices==null)return 0;
        int profit =0;
        int maxProfitableValue=prices[prices.length-1];

        for(int i=prices.length-2;i>=0;i--){
            if (maxProfitableValue-prices[i]>profit){
                profit=maxProfitableValue-prices[i];
            }
            if(maxProfitableValue<prices[i]){
                maxProfitableValue=prices[i];
            }
        }
        return profit;
    }
}
