package Collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task2 {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    Set<String> countries = new HashSet<>();
    countries.add("Vietnam");
    countries.add("Laos");
    countries.add("Thailand");

    int choice;

    do {
      System.out.println("==================");
      System.out.println("1. Add country");
      System.out.println("2. Check all countries");
      System.out.println("3. Check a country");
      System.out.println("4. Delete a country");
      System.out.println("5. Count number countries");
      System.out.println("0. Exit");
      System.out.print("Enter your choice: ");

      choice = myObj.nextInt();

      switch (choice) {
        case 1:
          System.out.println("Enter country name: ");
          String country = myObj.next();
          countries.add(country);
          break;

        case 2:
          System.out.println("Countries: " + countries);
          break;

        case 3:
          System.out.println("Enter country name: ");
          String checkCountry = myObj.next();
          System.out.println("Country is present: " + countries.contains(checkCountry.trim()));
          break;

        case 4:
          System.out.print("Enter country to delete: ");
          String deleteCountry = myObj.next();
          if (countries.remove(deleteCountry)) {
            System.out.println("Deleted successfully.");
          } else {
            System.out.println("Country not found.");
          }
          break;

        case 5:
          System.out.println("Number is present: " + countries.size());
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
