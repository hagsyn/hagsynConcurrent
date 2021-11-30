package cn.hagsyn.algorithm;

/**
 * [121]买卖股票的最佳时机
 *
 * @author Hagsyn
 * @date 2021/11/29
 */
public class Solution121 {
    public static int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};
        System.out.println(maxProfit(a));
    }

}