package Collection;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task17 {
  public static Set<Integer> add(){
    Scanner scanner1 = new Scanner(System.in);
    System.out.println("Enter length of array:");
    int length = scanner1.nextInt();

    Set<Integer> result1 = new HashSet();
    int i = 0;
    System.out.println("Enter elements:");
    while (i < length) {
      int number = scanner1.nextInt();
      if(result1.contains(number)) {
        result1.remove(number);
      } else {
        result1.add(number);
      }
      i++;
    }
    System.out.println(result1);
    return result1;
  }

  public static void main(String[] args) {
    System.out.println("Input your dataset: ");
    Task17.add();
  }
}
