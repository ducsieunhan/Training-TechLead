
package Collection;

import java.util.*;

public class Task8 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Map<Integer, Product> products = new HashMap<>();
    Random random = new Random();

    while (true) {
      System.out.println("1. Add product");
      System.out.println("2. View all products");
      System.out.println("3. View product by ID");
      System.out.print("Choose option: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          System.out.println("Enter student information (type 'done' for name to finish):");

          while (true) {
            System.out.print("Enter product name: ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("done")) {
              break;
            }

            System.out.print("Enter product price: ");
            int price = scanner.nextInt();
            scanner.nextLine();

            products.put(random.nextInt(1000), new Product(name, null, price, null));
            System.out.println("Product added successfully!");
          }
          break;

        case 2:
          System.out.println("All products:");
          for (int key : products.keySet() ) {
            System.out.println(key + ": " + products.get(key));
          }
          break;

        case 3:
          System.out.println("Enter product ID to find: ");
          System.out.println(products.get(scanner.nextInt()));
          break;
      }
    }
  }
}