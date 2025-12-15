package Collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task13 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Set<Integer> numbers = new HashSet<>();
    ArrayList<Integer> repeat = new ArrayList<>();

    System.out.println("Enter integers (type 'done' to finish):");

    while (scanner.hasNext()) {
      if (scanner.hasNextInt()) {
        int value = scanner.nextInt();
        if (numbers.contains(value)) {
          repeat.add(value);
        } else {
          numbers.add(value);
        }
      } else {
        String text = scanner.next();
        if (text.equalsIgnoreCase("done")) {
          break;
        } else {
          System.out.println("Please enter a valid integer or 'done' to finish.");
        }
      }
    }

    System.out.println("Unique numbers: " + numbers);
    System.out.println("Repeated numbers: " + repeat);
  }
}
