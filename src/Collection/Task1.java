package Collection;

import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    ArrayList<Integer> numbers = new ArrayList<>();
    numbers.add(10);
    numbers.add(20);
    numbers.add(30);

    int choice;

    do {
      System.out.println("==================");
      System.out.println("1. Show Sum");
      System.out.println("2. Show Maximum");
      System.out.println("3. Show Minimum");
      System.out.println("4. Delete a Value");
      System.out.println("5. Check a Value");
      System.out.println("6. Show All Numbers");
      System.out.println("0. Exit");
      System.out.print("Enter your choice: ");

      choice = myObj.nextInt();

      switch (choice) {
        case 1:
          int sum = 0;
          for (int i : numbers) sum += i;
          System.out.println("Sum: " + sum);
          break;

        case 2:
          int max = numbers.get(0);
          for (int i : numbers) if (i > max) max = i;
          System.out.println("Maximum: " + max);
          break;

        case 3:
          int min = numbers.get(0);
          for (int i : numbers) if (i < min) min = i;
          System.out.println("Minimum: " + min);
          break;

        case 4:
          System.out.print("Enter value to delete: ");
          int del = myObj.nextInt();
          if (numbers.remove(Integer.valueOf(del))) {
            System.out.println("Deleted successfully.");
          } else {
            System.out.println("Value not found.");
          }
          break;

        case 5:
          System.out.print("Enter value to check: ");
          int check = myObj.nextInt();
          System.out.println("Value is present: " + numbers.contains(check));
          break;

        case 6:
          System.out.println("Numbers: " + numbers);
          break;

        case 0:
          System.out.println("Exiting program...");
          break;

        default:
          System.out.println("Invalid choice. Try again.");
      }

    } while (choice != 0);

    myObj.close();
  }
}
