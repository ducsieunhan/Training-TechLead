package Collection;

import java.util.*;

public class Task3 {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    Map<String, Integer> people = new HashMap<>();
    people.put("John", 20);
    people.put("Jack", 25);
    int choice;

    do {
      System.out.println("==================");
      System.out.println("1. Add person");
      System.out.println("2. Check all people");
      System.out.println("3. Check a person's age");
      System.out.println("4. Delete a person");
      System.out.println("5. Check person's existence");
      System.out.println("0. Exit");
      System.out.print("Enter your choice: ");

      choice = myObj.nextInt();

      switch (choice) {
        case 1:
          System.out.println("Enter person information: ");
          System.out.print("Person name: ");
          String person = myObj.next();
          System.out.print("Person age: ");
          int age = myObj.nextInt();
          people.put(person, age);
          break;

        case 2:
          System.out.println("People: " + people);
          break;

        case 3:
          System.out.println("Enter person name: ");
          String checkPerson = myObj.next();
          System.out.println("Person's age: " + people.get(checkPerson.trim()));
          break;

        case 4:
          System.out.print("Enter person name to delete: ");
          String deletePerson = myObj.next();
          if (people.remove(deletePerson.trim()) != null) {
            System.out.println("Deleted successfully.");
          } else {
            System.out.println("Person not found.");
          }
          break;

        case 5:
          System.out.println("Enter person name: ");
          String checkPersonExists = myObj.next();
          System.out.println("Person is existed: " + people.containsKey(checkPersonExists.trim()));
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
