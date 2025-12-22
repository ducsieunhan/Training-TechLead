package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExtraScanner {
  public static String[] inputArrayStrings(){
    System.out.println("Enter strings (type 'done' to finish):");
    Scanner scanner = new Scanner(System.in);
    List<String> arr = new ArrayList<>();

    while (true) {
      String input = scanner.nextLine();
      if (input.equalsIgnoreCase("done")) {
        break;
      }
      arr.add(input);
    }
    return arr.toArray(new String[0]);
  }

  public static int[] inputArrayNumbers(){
    Scanner scanner = new Scanner(System.in);
    List<Integer> numbers = new ArrayList<>();

    System.out.println("Enter integers (type 'done' to finish):");

    while (scanner.hasNext()) {
      if (scanner.hasNextInt()) {
        int value = scanner.nextInt();
        numbers.add(value);
      } else {
        String text = scanner.next();
        if (text.equalsIgnoreCase("done")) {
          break;
        } else {
          System.out.println("Please enter a valid integer or 'done' to finish.");
        }
      }
    }
    return numbers.stream().mapToInt(Integer::intValue).toArray();
  }
}
