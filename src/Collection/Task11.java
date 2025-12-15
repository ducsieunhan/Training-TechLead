package Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task11 {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    Map<String, String> dictionary = new HashMap<>();
    int choice;

    do {
      System.out.println("==================");
      System.out.println("1. Add single word with definition");
      System.out.println("2. Search definition of a word");
      System.out.println("3. Get all words with definition");
      System.out.println("0. Exit");
      System.out.print("Enter your choice: ");

      choice = myObj.nextInt();
      myObj.nextLine();

      switch (choice) {
        case 1:
          System.out.println("Enter word information: ");
          System.out.print("Enter word: ");
          String word = myObj.nextLine();
          System.out.print("Enter definition: ");
          String definition = myObj.nextLine();

          dictionary.put(word, definition);
          break;

        case 2:
          System.out.print("Enter word to find definition: ");
          String wordToFind = myObj.nextLine();

          if (dictionary.containsKey(wordToFind)) {
            System.out.println("Definition: " + dictionary.get(wordToFind));
          } else {
            System.out.println("Word not found.");
          }
          break;

        case 3:
          for (String key : dictionary.keySet()) {
            System.out.println(key + ": " + dictionary.get(key));
          }

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
