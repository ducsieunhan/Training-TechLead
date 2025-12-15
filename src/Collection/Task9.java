package Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task9 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Map<String, Integer> map = new HashMap<>();

    System.out.println("Input your paragraph: ");
    String paragraph = input.nextLine();
    System.out.println(paragraph);

    String[] words = paragraph.split(" ");
    for(String word : words){
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    for(String key : map.keySet()){
      System.out.println(key + ": " + map.get(key));
    }
  }

}
