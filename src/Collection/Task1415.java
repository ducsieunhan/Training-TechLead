package Collection;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Task1415 {
  public List<Integer> innerJoin(Set<Integer> set1, Set<Integer> set2){
    return set1.stream().filter(set2::contains).toList();
  }

  public Set<Integer> union(Set<Integer> set1, Set<Integer> set2){
    Set<Integer> result = new HashSet<>(set1);
    result.addAll(set2);
    return result;
  }



  public static void main(String[] args) {
    Scanner scanner1 = new Scanner(System.in);
    System.out.println("Input set 1");
    Set<Integer> result = BuildSet.add();
    System.out.println("Input set 2");
    Set<Integer> result2 = BuildSet.add();

    int choice;
    do {
      System.out.println("==================");
      System.out.println("1. Find intersection of two sets");
      System.out.println("2. Find union of two sets");
      System.out.println("3 Print all elements of both sets");
      System.out.println("0. Exit");
      System.out.print("Enter your choice: ");

      choice = scanner1.nextInt();

      switch (choice) {
        case 1:
          System.out.println("Duplicate elements in set 1 and set 2:");
          System.out.println(new Task1415().innerJoin(result, result2));
          break;
        case 2:
          System.out.println("Union of set 1 and set 2:");
          System.out.println(new Task1415().union(result, result2));
          break;
        case 3:
          System.out.print("Set 1: ");
          System.out.println(result);
          System.out.print("Set 2:");
          System.out.println(result2);
        case 0:
          System.out.println("Exiting program...");
      }


    } while (choice != 0);
  }
}
