package Algorithm;

import java.util.*;

import static Algorithm.ExtraScanner.inputArrayNumbers;
import static Algorithm.ExtraScanner.inputArrayStrings;

public class Level1 {
  public static int sum(int a, int b) {
    return a + b;
  }

  public static int stringLength(String str) {
    return str.length();
  }

  public static int square(int a) {
    return a * a;
  }

  public static int findMax(int[] arr){
    return Arrays.stream(arr).max().getAsInt();
  }

  public static void findShortestString(String[] arr){
    Arrays.sort(arr, (a, b) -> a.length() - b.length());
  }

  public static void sortingArrayASC(int[] arr){
    Arrays.sort(arr);
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }

  public static void sortingArrayStringAlp(String[] arr){
    Arrays.sort(arr);
    for (String i : arr) {
      System.out.print(i + " ");
    }
  }

  public static int median(int[] arrays){
    return arrays[arrays.length/2];
  }

  public static int numberOfWords(String str){
    return str.split(" ").length;
  }

  public static long numberOfStringIncludeA(String[] arr){
    return Arrays.stream(arr).filter(a -> a.contains("a")).count();
  }

  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    int choice;

    do {
      System.out.println("==================");
      System.out.println("1. Sum of two numbers");
      System.out.println("2. Length of a word");
      System.out.println("3. Square of a number");
      System.out.println("4. Find maximum in array");
      System.out.println("5. Find shortest string");
      System.out.println("6. Sort array ascending");
      System.out.println("7. Sort strings alphabetically");
      System.out.println("8. Find median");
      System.out.println("9. Count words in sentence");
      System.out.println("10. Count strings containing 'a'");
      System.out.println("0. Exit");
      System.out.print("Enter your choice: ");

      choice = myObj.nextInt();
      myObj.nextLine();

      switch (choice) {
        case 1:
          System.out.println("Enter two numbers: ");
          int a = myObj.nextInt();
          int b = myObj.nextInt();
          System.out.println("Sum: " + sum(a, b));
          break;

        case 2:
          System.out.println("Enter a word: ");
          String str = myObj.nextLine();
          System.out.println("Length of this word: " + stringLength(str));
          break;

        case 3:
          System.out.println("Enter a number: ");
          int num = myObj.nextInt();
          System.out.println("Square: " + square(num));
          break;

        case 4:
          System.out.println("Enter the array: ");
          int[] arr = inputArrayNumbers();
          System.out.println("Maximum: " + findMax(arr));
          break;

        case 5:
          System.out.println("Enter strings: ");
          String[] strArr = inputArrayStrings();
          findShortestString(strArr);
          System.out.println("Strings sorted by length: ");
          for (String s : strArr) {
            System.out.print(s + " ");
          }
          System.out.println();
          break;

        case 6:
          System.out.println("Enter the array: ");
          int[] arr1 = inputArrayNumbers();
          sortingArrayASC(arr1);
          break;

        case 7:
          System.out.println("Enter strings: ");
          String[] strArr1 = inputArrayStrings();
          sortingArrayStringAlp(strArr1);
          break;

        case 8:
          System.out.println("Enter the array: ");
          int[] arr2 = inputArrayNumbers();
          System.out.println("Median: " + median(arr2));
          break;

        case 9:
          System.out.println("Enter a sentence: ");
          String sentence = myObj.nextLine();
          System.out.println("Number of words: " + numberOfWords(sentence));
          break;

        case 10:
          System.out.println("Enter the number of strings: ");
          System.out.println("Enter strings: ");
          String[] strArr2 = inputArrayStrings();
          System.out.println("Strings containing 'a': " + numberOfStringIncludeA(strArr2));
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
