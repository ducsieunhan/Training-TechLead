package Collection;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task12 {
  public static void sortAndPrint(List<Product> products, Comparator<Product> comparator) {
    products.sort(comparator);
    System.out.println(products);
  }

  public static void main(String[] args) {
    Random random = new Random();
    List<Product> products = IntStream.rangeClosed(1,10)
            .mapToObj(i -> new Product("Product " + random.nextInt(10000), "P" + random.nextInt(10000), random.nextInt(10000), "2025-01-0" + i))
            .collect(Collectors.toList());

    System.out.println("Sorted by name:");
    sortAndPrint(products, Comparator.comparing(p -> p.name));

    System.out.println("Sorted by price:");
    sortAndPrint(products, (p1, p2) -> p1.price > p2.price ? 1 : -1);

    System.out.println("Sorted by created date:");
    sortAndPrint(products, Comparator.comparing(p -> p.createdDate));

    System.out.println("Sorted by price and created date:");
    sortAndPrint(products, Comparator.comparing((Product p) -> p.createdDate)
            .thenComparing(p -> p.price));
  }
}


