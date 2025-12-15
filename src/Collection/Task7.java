package Collection;

import java.util.Map;

public class Task7 {
  public static double average(Double[] numbers){
    double sum = 0;
    for(double number : numbers){
      sum += number;
    }
    return sum / numbers.length;
  }

  public static void main(String[] args) {
    Map<String, Double[]> map = Map.of(
            "John", new Double[]{9.4, 8.7, 7.8, 9.1},
            "Jack", new Double[]{2.5, 6.7, 5.8, 7.1},
            "Jill", new Double[]{8.7, 7.5, 6.9, 10.0}
    );

    for(String name : map.keySet()){
      System.out.println("Average point of "+ name + ": " + average(map.get(name)));
    }

  }
}
