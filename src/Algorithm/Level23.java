package Algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import static Algorithm.ExtraScanner.inputArrayNumbers;
import static Algorithm.ExtraScanner.inputArrayStrings;

public class Level23 {

  // 2.1
  public static int findSecondLargest(int[] arr){
    Arrays.sort(arr);
    return arr[arr.length-2];
  }

  //2.2
  public static String findLongestString(String[] arr){
    String longest = arr[0];
    for(String str : arr){
      if(str.length() > longest.length()){
        longest = str;
      }
    }
    return longest;
  }

  //2.3
//  public static String longestCommon(String str1, String str2){
//
//  }

  //2.4
  public static int sumOfNumbersDevidableBy3And5(int[] numbers){
    return Arrays.stream(numbers).filter(n -> n % 3 == 0 && n % 5 == 0).sum();
  }

  //2.5
  public static int findMaxConti(int[] numbers){
    int max = 0 ;
    int curMax = numbers[0];

    for(int i = 1; i < numbers.length; i++){
      curMax = Math.max(numbers[i], curMax + numbers[i]);
      max = Math.max(max, curMax);
    }
    return max;
  }

  // 3.1

  public static int findSecondSmallest(int[] arr){
    Arrays.sort(arr);
    return arr[1];
  }

//   3.2
  public static int maximumDiff(int[] numbers){
    int max = numbers[0];
    for(int i = 0; i < numbers.length; i++){
      int currentSum = 0;
      for(int j = i+1; j < numbers.length; j++){
        currentSum = numbers[j] - numbers[i];

        max = Math.max(max, currentSum);
      }
    }
    return max;
  }

  // 3.3

  public static int LIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);

    for (int i = 1; i < n; ++i) {
      for (int j = 0; j < i; ++j) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    int maxLength = Arrays.stream(dp).max().orElse(0);
    return maxLength;
  }


  // 3.4
  public static String[] largestOverlap(String[] numbers){
    int largest = 0;
    String str1 = "";
    String str2 = "";
    for(int i = 0 ; i < numbers.length; i++ ){
      for(int j = i+1; j < numbers.length; j++){
        int calOverlap = calOverlap(numbers[i], numbers[j]);
        if(calOverlap > largest){
          largest = calOverlap;
          str1 = numbers[i];
          str2 = numbers[j];
        }
      }
    }
    return new String[]{str1, str2};
  }

  // 3.4.1
  public static int calOverlap(String str1, String str2){
    int[] alp1 = new int[26];
    int[] alp2 = new int[26];

    for(int i = 0; i < str1.length(); i++){
      alp1[str1.charAt(i) - 'a']++;
    }
    for(int i = 0; i < str2.length(); i++){
      alp2[str2.charAt(i) - 'a']++;
    }
    int overlap = 0;
    for(int i = 0; i < 26; i++){
      overlap += Math.min(alp1[i], alp2[i]);
    }
    return overlap;
  }

  // 3.5
  public static int smallestPositive(int[] arr){
    Arrays.sort(arr);
   int target = 1;
   for(int i = 0; i < arr.length; i++){
     if(arr[i] > target) break;

     target += arr[i];
   }
   return target;
  }

  // 3.6
  public static int medianOfTwoArray(int[] arr1, int[] arr2){
    int medianPos = (arr1.length + arr2.length) / 2;
    if(medianPos > arr1.length) return arr2[medianPos - arr1.length - 1];
    return arr1[medianPos];
  }

  // 3.10

  public static List<String> sortString(List<String> arr){
    arr.sort((a, b) -> {
      int distinct1 = new HashSet<>(List.of(a.split(""))).size();
      int distinct2 = new HashSet<>(List.of(b.split(""))).size();

      if(distinct1 != distinct2) return Integer.compare(distinct1, distinct2);

      return Integer.compare(a.length(), b.length());
    });
    return arr;
  }

  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    int choice;

    do {
      System.out.println("==================");
      System.out.println("==================Level 2==================");
      System.out.println("1:2.1 Second largest number in an array");
      System.out.println("2:2.2 Longest string in an array");
      System.out.println("4:2.4 Sum of the numbers that are divisible by both 3 and 5");
      System.out.println("5:2.5 The maximum sum of any contiguous subarray within the list");
      System.out.println("==================Level 3==================");
      System.out.println("6:3.1 Second smallest number in an array");
      System.out.println("7:3.2 The maximum difference between any two elementary");
      System.out.println("8:3.4 The two strings with the largest overlap of characters.");
      System.out.println("9:3.5 The smallest positive integer that cannot be represented as the sum of any subset of the list");
      System.out.println("10:3.6 The median of the combined list");
      System.out.println("11:3.3 The median of the combined list");
      System.out.println("12:3.10 The median of the combined list");
      System.out.println("0. Exit");
      System.out.print("Enter your choice: ");

      choice = myObj.nextInt();
      myObj.nextLine();

      switch (choice) {
        case 1:
          System.out.println("Enter the array: ");
          int[] arr = inputArrayNumbers();
          System.out.println("Second largest number: " + findSecondLargest(arr));
          break;

        case 2:
          System.out.println("Enter the array: ");
          String[] arr3 = inputArrayStrings();
          System.out.println("Length of this word: " + findLongestString(arr3));
          break;

        case 3:
          break;
//
        case 4:
          System.out.println("Enter the array: ");
          int[] arr1 = inputArrayNumbers();
          System.out.println("Sum: " + sumOfNumbersDevidableBy3And5(arr1));
          break;

        case 5:
          System.out.println("Enter the array: ");
          int[] arr4 = inputArrayNumbers();
          System.out.println("The maximum sum of any contiguous subarray within the list: " + findMaxConti(arr4));
          break;
        case 6:
          System.out.println("Enter the array: ");
          int[] arr2 = inputArrayNumbers();
          System.out.println("Second largest number: " + findSecondSmallest(arr2));
          break;

        case 7:
          System.out.println("Enter the array: ");
          int[] arr5 = inputArrayNumbers();
          System.out.println("Second largest number: " + maximumDiff(arr5));
          break;

        case 8:
          System.out.println("Enter the array: ");
          String[] arr6 = inputArrayStrings();
          String[] result = largestOverlap(arr6);
          System.out.println("The two strings with the largest overlap of characters: " + Arrays.toString(result));
        case 9:
          System.out.println("Enter the array: ");
          int[] arr7 = inputArrayNumbers();
          System.out.println("the smallest positive integer that cannot be represented as the sum of any subset of the list: " + smallestPositive(arr7));
          break;

        case 10:
          System.out.println("Enter the array 1: ");
          int[] arr8 = inputArrayNumbers();

          System.out.println("Enter the array 2: ");
          int[] arr9 = inputArrayNumbers();

          System.out.println("Median of two array: " + medianOfTwoArray(arr8, arr9));

        case 11:
          System.out.println("Enter a number: ");
          int[] ar5 = inputArrayNumbers();
          System.out.println("The longest increasing subsequence: " + LIS(ar5));
          break;
        case 12:
          System.out.println("Enter the array: ");
          String[] arr10 = inputArrayStrings();
          List<String> sort = sortString(Arrays.asList(arr10));
          System.out.println(sort);
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
