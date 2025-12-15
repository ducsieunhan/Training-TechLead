package Collection;

import java.util.*;

public class Task4 {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    ArrayList<Integer> al = new ArrayList<Integer>(
            Arrays.asList(3,1,4,6,3,5,7,8,4));

    int choice;

    do{
      System.out.println("==================");
      System.out.println("List: " + al);
      System.out.println("1. Sorting in ascending order");
      System.out.println("2. Sorting in descending order");
      System.out.println("0. Exit");
      System.out.print("Enter your choice: ");

      choice = myObj.nextInt();

      switch (choice) {
        case 1:
          Collections.sort(al);
          System.out.println("List with asc order: " + al);
          break;

        case 2:
          al.sort(Collections.reverseOrder());
          System.out.println("List with desc order: " + al);
          break;

        case 0:
          System.out.println("Exiting program...");
          break;

        default:
          System.out.println("Invalid choice. Try again.");
      }

    } while (choice != 0);

  }
}
