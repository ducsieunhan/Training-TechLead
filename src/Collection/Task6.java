package Collection;

import java.util.Random;

public class Task6 {

  public static int stock(int[] prices){
    int leastPrice = Integer.MAX_VALUE;
    int profit = 0;
    int todayProfit = 0;

    for(int i = 0 ; i < prices.length ; i++){
      if(prices[i] < leastPrice){
        leastPrice = prices[i];
      }
      todayProfit = prices[i] - leastPrice;
      if(profit < todayProfit) profit = todayProfit;
    }
    return profit;
  }

  public static void main(String[] args) {
    Random random = new Random();
    int[] arr = new int[6];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = random.nextInt(10);
    }

    for (int i : arr) System.out.print(i + " ");
    System.out.println();
    System.out.println(stock(arr));
  }

}
