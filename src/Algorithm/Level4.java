package Algorithm;

import java.util.*;

import static Algorithm.ExtraScanner.inputArrayNumbers;
import static Algorithm.ExtraScanner.inputArrayStrings;

public class Level4 {

  // 4.1
  public static int[] bubleSort(int[] arr){
    for(int i = 0; i < arr.length - 1; i++){
      for (int j = 0; j < arr.length - i - 1; j++) {
        if(arr[j] > arr[j + 1]){
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
    return arr;
  }

  // 4.2

  public static int distinctSubsequent(int[] arr, int k){
    int count = 0;
    for(int i = 0 ; i < arr.length; i++){
      for(int j = i + 1; j < arr.length; j++){
        if(arr[i] + arr[j] == k) count++;
      }
    }
    return count;
  }

  // 4.3

  public static int longestSubstring(String[] arr){
    String shortest = Arrays.stream(arr)
            .filter(Objects::nonNull)
            .min((a, b) -> Integer.compare(a.length(), b.length()))
            .orElse(null);

    for(int i = shortest.length(); i > 0; i--){
      boolean isLongest = false;
      for(String s : arr){
        if(s.contains(shortest.substring(0,i))){
          isLongest = true;
        } else {
          isLongest = false;
        }
      }
      if(isLongest){
        return i;
      }
    }
    return 1;
  }

  // 4.6
  public static int maxValueThreeElements(int[] arr){
    bubleSort(arr);
    int n = arr.length;
    int max1 = arr[n - 1] * arr[n - 2] * arr[n - 3];
    int max2 = arr[0] * arr[1] * arr[n - 1];
    return Math.max(max1, max2);
  }

  // 4.7
  public static String[] sortStringByUniqueChars(String[] arr){
    for(int i = 0; i < arr.length - 1; i++){
      for (int j = 0; j < arr.length - i - 1; j++) {
        if(countUnique(arr[j]) < countUnique(arr[j + 1])){
          String temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
    return arr;
  }

  // 4.7.1
  public static int countUnique(String a){
    Map<Character, Integer> count = new HashMap<>();
    int sum = 0;
    for(char c : a.toCharArray()){
      if(count.containsKey(c)){
        count.put(c, count.getOrDefault(c, 0) + 1);
      } else {
        count.put(c, 1);
        sum++;
      }
    }
    return sum;
  }

  // 4.9
  public static int subsequent(int[] arr) {
    if (arr == null || arr.length == 0) return 0;
    int max = 1;
    int wrap = 1;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == arr[i - 1] + 1) {
        wrap++;
      } else {
        wrap = 1;
      }
      max = Math.max(max, wrap);
    }
    return max;
  }


  // 4.10

  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    int choice;

    do {
      System.out.println("==================");
      System.out.println("==================Level 4==================");
      System.out.println("1: Bubble Sort");
      System.out.println("2: The number of distinct subsequences of the list ");
      System.out.println("3: The length of the longest substring");
      System.out.println("4: Option 4");
      System.out.println("5: Option 5");
      System.out.println("6: The maximum product of any three distinct elements");
      System.out.println("7: The list sorted by the number of distinct words");
      System.out.println("8: Option 8");
      System.out.println("9: The length of the longest increasing subsequence of the numbers");
      System.out.println("0. Exit");
      System.out.print("Enter your choice: ");

      choice = myObj.nextInt();
      myObj.nextLine();

      switch (choice) {
        case 1:
          System.out.println("Enter the array: ");
          int[] arr = inputArrayNumbers();
          bubleSort(arr);
          for (int i : arr) {
            System.out.print(i + " ");
          }
          break;

        case 2:
          System.out.println("Enter the array: ");
          int[] arr3 = inputArrayNumbers();
          System.out.println("Enter keynumber: ");
          int k = myObj.nextInt();

          System.out.println("Number of distinct consecutive numbers: " + distinctSubsequent(arr3, k) + "||");
          break;

        case 3:
          System.out.println("Enter strings: ");
          String[] str1 = inputArrayStrings();
          System.out.println("Longest substring: " + longestSubstring(str1) + "||");
          break;

        case 4:
          // TODO: Implement case 4
          break;

        case 5:
          // TODO: Implement case 5
          break;

        case 6:
          System.out.println("Enter the array: ");
          int[] arr1 = inputArrayNumbers();
          System.out.println("Maximum value: " + maxValueThreeElements(arr1) + "||");
          break;

        case 7:
          System.out.println("Enter strings: ");
          String[] strArr = inputArrayStrings();
          System.out.println("After sorting:");
          for (String s : sortStringByUniqueChars(strArr)) {
            System.out.print(s + "||");
          }
          break;

        case 8:
          // TODO: Implement case 8
          break;

        case 9:
          System.out.println("Enter the array: ");
          int[] arr2 = inputArrayNumbers();
          System.out.println("Maximum consecutive numbers: " + subsequent(arr2) + "||");
          break;

        case 10:
          // TODO: Implement case 10
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
