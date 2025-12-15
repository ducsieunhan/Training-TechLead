package Collection;

import java.util.HashMap;
import java.util.Scanner;

public class Task5 {

  public double[] findSum(double[] numbers, double x){
    HashMap<Double, Integer> map = new HashMap<>();

    for(int i = 0; i < numbers.length; i++){
      double remain = x - numbers[i];
      if(map.containsKey(remain)){
        return new double[]{remain, numbers[i]};
      }
      map.put(numbers[i], i);
    }
    return new double[0];
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double[] numbers = new double[5];

    for (int i = 0; i < numbers.length; i++) {
      System.out.println("Please enter number");
      numbers[i] = input.nextDouble();
    }

    System.out.print("Input number want to find: ");
    double x = input.nextDouble();
    double[] output = new Task5().findSum(numbers, x);

    if (output.length == 0) {
      System.out.println("Not found");
    } else {
      System.out.println("Found:");
      for (double result : output) {
        System.out.print(result + " ");
      }
    }
  }
}
