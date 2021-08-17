package Leet.Greedy.买卖一次股票的最大利润;

public class Offer63 {
    /*
     * 买卖一次股票的最大利润
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        if(prices.length==0){return 0;}
        for(int i = 0; i <prices.length-1; i++){
            int money = prices[i+1]-prices[i];
            if(money>0){
                res+=money;
            }
        }
        return res;
    }
}
