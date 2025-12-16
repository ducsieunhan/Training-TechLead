package Collection;

import java.util.Collections;
import java.util.Set;

public class Task16 {
  public static void main(String[] args) {
    System.out.println("Input your dataset: ");
    Set<Integer> set = BuildSet.add();

    System.out.println("Maximum value of HashSet : "
            + Collections.max(set));

    System.out.println("Minimum value of HashSet : "
            + Collections.min(set));
  }
}
