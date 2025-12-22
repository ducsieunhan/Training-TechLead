package Algorithm;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static Algorithm.ExtraScanner.inputArrayNumbers;
import static Algorithm.ExtraScanner.inputArrayStrings;

public class Level5 {
  static List<Order> orders = Arrays.asList(
          new Order("10", "0"),
          new Order("12", "1"),
          new Order("9", "2"),
          new Order("11", "3")
  );

  public static int[] reverseArray(int[] arr){
    int start = 0 ;
    int end = arr.length - 1 ;

    while(start < end){
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
    return arr;
  }

  // 5.2
  public static List<String[]> chunk(String[] arr, int length){
    List<String[]> list = new ArrayList<>();
    for(int i = 0; i < arr.length; i += length){
      int end = Math.min(arr.length, i + length);
      String[] temp = Arrays.copyOfRange(arr, i, end);
      list.add(temp);
    }
    return list;
  }

  // 5.3
  public static List<Integer> removeDuplicates(int[] arr){
    List<Integer> list = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    for(int i : arr){
      if(set.add(i)){
        list.add(i);
      }
    }
    return list;
  }

  // 5.4

  public static List<Map<String, Object>> uniqArrayObject(List<Map<String, Object>> collections) {
    Set<String> seen = new HashSet<>();
    List<Map<String, Object>> result = new ArrayList<>();

    for (Map<String, Object> obj : collections) { // [{ 'x': 1, 'y': 2 }, { 'x': 2, 'y': 1 }, { 'y': 2, 'x': 1 }]
      List<String> keys = new ArrayList<>(obj.keySet());
      Collections.sort(keys);

      StringBuilder sb = new StringBuilder();
      for (String key : keys) {
        sb.append(key).append(":").append(obj.get(key)).append(",");
      }
      String signature = sb.toString();

      if (seen.add(signature)) {
        result.add(obj);
      }
    }
    return result;
  }

  // 5.5

  public static Map<Integer, List<Map<String, Object>>> groupByObject(List<Map<String, Object>> collections, String key) {
    Map<Integer, List<Map<String, Object>>> result = new HashMap<>();

    for (Map<String, Object> obj : collections) {
      if (obj.containsKey(key)) {
        int group = (int) obj.get(key);

        result.putIfAbsent(group, new ArrayList<>());

        result.get(group).add(obj);
      }
    }

    return result;
  }

  // 5.6
  public static String trimAll(String a){
    a = a.trim();
    a = a.replaceAll("\\s+", " ");
    return a;
  }

  // 5.7

  public static List<Map<String, Object>> groupByArray(List<Map<String, Object>> collections, List<String> keys){
    List<Map<String, Object>> result = new ArrayList<>();
    for(Map<String, Object> map : collections){
      Map<String, Object> temp = new HashMap<>();
      for(String key : map.keySet()){
        if(keys.contains(key)){
          temp.put(key, map.get(key));
        }
      }
      result.add(temp);
    }
    return result;
  }

  // 5.8

  public static void switchOrder(String id, String newOrder) {
    Order target = null;
    for (Order o : orders) {
      if (o.getId().equals(id)) {
        target = o;
        break;
      }
    }

    if (target == null) {
      System.out.println("Order with id " + id + " not found.");
      return;
    }

    List<Order> tempList = new ArrayList<>(orders);
    tempList.remove(target);

    int pos = Integer.parseInt(newOrder);
    tempList.add(pos, target);

    for (int i = 0; i < tempList.size(); i++) {
      tempList.get(i).setOrder(String.valueOf(i));
    }

    orders = tempList;
  }


  // 5.9

  public static Map<String, Integer> sumAll(List<Map<String, Integer>> list){
    Map<String, Integer> result = new HashMap<>();

    for(Map<String, Integer> map : list){
      List<String> keys = new ArrayList<>(map.keySet());
      for(String key : keys){
        result.putIfAbsent(key, 0);
        result.put(key, result.get(key) + map.get(key));
      }
    }
    return result;
  }

  // 5.10
  public static void readFile(String filename, Map<String, String> params){
    try {
      File file = new File(filename);
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        String data = scanner.nextLine();
//        data = data.replaceAll("file", "file2");
        for(String key : params.keySet()){
          data = data.replace(key, params.get(key));
        }
        System.out.println(data);
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    int choice;

    do {
      System.out.println("==================");
      System.out.println("==================Level 3==================");
      System.out.println("1: Reverse an array");
      System.out.println("2: Option 2");
      System.out.println("3: Option 3");
      System.out.println("4: Option 4");
      System.out.println("5: Option 5");
      System.out.println("6: Option 6");
      System.out.println("7: Option 7");
      System.out.println("8: Option 8");
      System.out.println("9: Option 9");
      System.out.println("10: Option 10");
      System.out.println("0. Exit");
      System.out.print("Enter your choice: ");

      choice = myObj.nextInt();
      myObj.nextLine();

      switch (choice) {
        case 1:
          System.out.println("Enter the array: ");
          int[] arr = inputArrayNumbers();
          System.out.println("Reversed array: ");
          for (int i : reverseArray(arr)) {
            System.out.print(i + " ");
          }
          break;
        case 2:
          System.out.println("Enter the array: ");
          String[] arr1 = inputArrayStrings();
          List<String[]> chunk = chunk(arr1, 3);
          for (String[] array : chunk){
            for (String s : array) {
              System.out.print(s + " ");
            }
            System.out.println();
          }
          break;
        case 3:
          System.out.println("Enter the array: ");
          int[] arr2 = inputArrayNumbers();
          System.out.println("Unique numbers: ");
          List<Integer> removeDuplicates = removeDuplicates(arr2);
          System.out.println(removeDuplicates);
          break;

        case 4:
          List<Map<String, Object>> collections1 = new ArrayList<>();
          collections1.add(new HashMap<>(Map.of("x", 1, "y", 2)));
          collections1.add(new HashMap<>(Map.of("x", 2, "y", 1)));
          collections1.add(new HashMap<>(Map.of("y", 2, "x", 1)));

          List<Map<String, Object>> result = uniqArrayObject(collections1);
          System.out.println(result);
          break;

        case 5:
          List<Map<String, Object>> collections2 = new ArrayList<>();
          collections2.add(new HashMap<>(Map.of("a", 1, "b", 2)));
          collections2.add(new HashMap<>(Map.of("a", 1, "b", 3)));
          collections2.add(new HashMap<>(Map.of("a", 2, "b", 2)));

          System.out.println("Input key you want to group by:");
          String key = myObj.next();
          Map<Integer, List<Map<String, Object>>> grouped = groupByObject(collections2, key);
          System.out.println(grouped);
          break;

        case 6:
          System.out.println("Enter a sentence: ");
          String sentence = myObj.nextLine();
          System.out.println("Trimmed sentence: " + trimAll(sentence));
          break;

        case 7:
          List<Map<String, Object>> collections4 = new ArrayList<>();
          collections4.add(new HashMap<>(Map.of("a", 1, "b", 8, "c", 3, "d", 8)));
          collections4.add(new HashMap<>(Map.of("a", 5, "b", 3, "c", 5, "e", 10)));
          collections4.add(new HashMap<>(Map.of("a", 23, "b", 7, "c", 7, "f", 18)));

          System.out.println("Input key you want to group by:");
          String[] arr3 = inputArrayStrings();
          List<String> keys = Arrays.asList(arr3);

          groupByArray(collections4, keys).forEach(System.out::println);
          break;

        case 8:
          System.out.println("Orders:");
          for (Order order : orders) {
            System.out.println(order);
          }
          System.out.println("Enter order id: ");
          String id = myObj.next();

          System.out.println("Enter order: ");
          String order = myObj.next();
          switchOrder(id, order);

          System.out.println("Orders after switch:");
          for (Order order1 : orders) {
            System.out.println(order1);
          }

          break;
        case 9:
          List<Map<String, Integer>> collections3 = new ArrayList<>();
          collections3.add(new HashMap<>(Map.of("x", 2, "y", 10)));
          collections3.add(new HashMap<>(Map.of("x", 12, "y", 11)));
          collections3.add(new HashMap<>(Map.of("y", 14, "x", 8, "z", 20)));

          Map<String, Integer> map = sumAll(collections3);
          System.out.println(map);

          break;

        case 10:
          Map<String, String> map1 = new HashMap<>();
          System.out.println("Input param you want to change value into:");
          for(int i = 0 ; i < 3; i ++){
            System.out.println("Input number " + (i + 1) + " param and value:");
            String param = myObj.next();
            String value = myObj.next();
            map1.put("{{"+param+"}}", value);
          }

          readFile("C:\\Users\\ADMIN\\OneDrive\\Attachments\\Documents\\TechLead\\Training-TechLead\\src\\Algorithm\\mockFile.txt",
                  map1
          );
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

class Order{
  String id;
  String order;

  public Order(String id, String order) {
    this.id = id;
    this.order = order;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getOrder() {
    return order;
  }

  public void setOrder(String order) {
    this.order = order;
  }

  @Override
  public String toString() {
    return "Order{" +
            "id='" + id + '\'' +
            ", order='" + order + '\'' +
            '}';
  }
}