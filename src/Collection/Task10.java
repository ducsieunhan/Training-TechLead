package Collection;

import java.util.*;

class Student{
  private String name;
  private int grade;

  public Student(String name, int grade) {
    this.name = name;
    this.grade = grade;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getGrade() {
    return grade;
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }

  @Override
  public String toString() {
    return "Student{name='" + name + "', grade=" + grade + "}";
  }
}

public class Task10 {

  public static void analyzeGradeDistribution(List<Student> students) {
    Map<Double, Integer> gradeCount = new HashMap<>();

    for (Student student : students) {
      double grade = student.getGrade();
      gradeCount.put(grade, gradeCount.getOrDefault(grade, 0) + 1);
    }

    int highGrade = 0;
    int averageGrade = 0;
    int failGrade = 0;

    for (Student student : students) {
      double grade = student.getGrade();
      if (grade >= 8.0) {
        highGrade++;
      } else if (grade >= 5.0) {
        averageGrade++;
      } else {
        failGrade++;
      }
    }

    System.out.println("High point (>= 8.0): " + highGrade + " students");
    System.out.println("Medium point (>= 5.0 và < 8.0): " + averageGrade + " students");
    System.out.println("Failed (< 5.0): " + failGrade + " student");
    System.out.println();

    System.out.println("Detail:");
    gradeCount.entrySet().stream()
            .sorted(Map.Entry.<Double, Integer>comparingByKey().reversed())
            .forEach(entry ->
                    System.out.println("Point " + entry.getKey() + ": " + entry.getValue() + " student"));

    System.out.println();
    System.out.println("Percent:");
    System.out.printf("High point: %.1f%%\n", highGrade );
    System.out.printf("Medium point: %.1f%%\n", averageGrade);
    System.out.printf("FAiled: %.1f%%\n", failGrade) ;
  }


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Student> students = new ArrayList<>();

    System.out.println("Enter student information (type 'done' for name to finish):");

    while (true) {
      System.out.print("Enter student name: ");
      String name = scanner.nextLine();

      if (name.equalsIgnoreCase("done")) {
        break;
      }

      System.out.print("Enter student grade: ");
      int grade = scanner.nextInt();
      scanner.nextLine();

      students.add(new Student(name, grade));
      System.out.println("Student added successfully!");
    }

    System.out.println("All students:");
    for (Student student : students) {
      System.out.println(student);
    }

    analyzeGradeDistribution(students);
    scanner.close();
  }
}