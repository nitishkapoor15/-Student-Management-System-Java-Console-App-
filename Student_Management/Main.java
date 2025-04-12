import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

class Main {

    public static void main(String[] args) {
        // pass the object in Arrraylist : - Student
        ArrayList<Student> students = new ArrayList<>();
        // take input from user
        Scanner sc = new Scanner(System.in);

        // menu to display the user..
        while (true) {
            System.out.println("\n----- Student Management Menu -----");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Students");
            System.out.println("4. delete students");
            System.out.println("5. Exit..");
            System.out.println("6. Save to file");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter a Roll no");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter a Name");
                    String name = sc.nextLine();

                    if (name.isEmpty() || roll <= 0) {
                        System.out.println("Student not added. Please enter valid name and roll number.");
                    } else {
                        students.add(new Student(name, roll)); // Add student to the list || Search google if you don't
                                                               // know how to add element in arraylist..
                        System.out.println("Student Added Successfully.."); // Confirmation message
                    }
                    break;
                // --------------------------------------------------------------------------------

                case 2:
                    // Using a for-each loop to print each object
                    System.out.println("List of Student");
                    for (Student view : students) {
                        System.out.println(view);
                    }
                    break;
                // --------------------------------------------------------------------------------
                case 3: // Search Students
                    System.out.println("Enter a roll no to find Student");
                    int searchRoll = sc.nextInt();
                    sc.nextLine();
                    boolean found = false; // Flag to check if student is found

                    for (Student student : students) {
                        if (student.roll == searchRoll) {
                            System.out.println("Student found : " + student.name + " " + ", Roll NO : " + student.roll);
                            found = true; // Set the flag to true if student is found
                            break; // Exit the loop once the student is found

                        }
                    }

                    if (!found) {
                        System.out.println("Not Existing any record");
                    }
                    break;

                // --------------------------------------------------------------------------------
                case 4:
                    System.out.print("Enter the roll number to delete: ");
                    int deleteRoll = sc.nextInt();
                    sc.nextLine();

                    boolean removed = false;
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).roll == deleteRoll) {
                            students.remove(i);
                            removed = true;
                            System.out.println("✅ Student deleted successfully.");
                            break;
                        }
                    }

                    if (!removed) {
                        System.out.println("❌ Student not found with roll number: " + deleteRoll);
                    }
                    break;
                // --------------------------------------------------------------------------------

                case 5:
                    System.out.println("Exiting...");
                    System.out.println("Thanks for using the Student Management System.");
                    sc.close();
                    System.exit(0); // Exit the program

                    // --------------------------------------------------------------------------------

                case 6:
                    try {
                        FileWriter writer = new FileWriter("students.txt");
                        for (Student s : students) {
                            writer.write(s.roll + "," + s.name + "\n");
                        }
                        writer.close();
                        System.out.println("✅ Students saved to students.txt");
                    } catch (IOException e) {
                        System.out.println("❌ Error saving file: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }

        }
    }

}
