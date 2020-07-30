//Problem:

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]

//Solution:

class Solution {
    public int maxProfit(int[] prices) {
		if(prices.length<2){
			return 0;
		}
    
    int[] dp = new int[prices.length];
    Arrays.fill(dp, -1);
    return getMaxProfit(prices, 0, dp);
}

private int getMaxProfit(int[] prices, int pos, int[] dp){
    if(pos>=prices.length){
        return 0;
    }
    
    //if already calculated, just return
    if(dp[pos]!=-1){
        return dp[pos];
    }
    
    int maxProfit = 0;
    for(int i=pos+1;i<prices.length;i++){
        int diff = prices[i]-prices[pos];
        if(diff>0){
            //Selling the stock bought at pos
            int profit = getMaxProfit(prices, i+2, dp)+diff;
            maxProfit=Math.max(maxProfit, profit);
        }
    }
    
    //skip buying stock at pos
    int profit = getMaxProfit(prices, pos+1, dp);
    maxProfit=Math.max(maxProfit, profit);
    dp[pos]=maxProfit;
    
    return maxProfit;
}
}