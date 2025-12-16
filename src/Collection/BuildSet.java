package Collection;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BuildSet {
  public static Set<Integer> add(){
    Scanner scanner1 = new Scanner(System.in);
    System.out.println("Enter length of array:");
    int length = scanner1.nextInt();

    Set<Integer> result1 = new HashSet();
    int i = 0;
    System.out.println("Enter elements:");
    while (i < length) {
      result1.add(scanner1.nextInt());
      i++;
    }
    System.out.println(result1);
    return result1;
  }
}
