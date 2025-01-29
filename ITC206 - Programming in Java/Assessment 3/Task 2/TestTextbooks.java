import java.util.ArrayList;

public class TestTextbooks {
    public static void main(String[] args) {
        // Create 4 objects of ProgrammingTextbook
        ProgrammingTextbook pt1 = new ProgrammingTextbook("Python 101", "John Doe", 300, "Python");
        ProgrammingTextbook pt2 = new ProgrammingTextbook("Java Basics", "Jane Smith", 450, "Java");
        ProgrammingTextbook pt3 = new ProgrammingTextbook("C++ Mastery", "Alan Johnson", 550, "C++");
        ProgrammingTextbook pt4 = new ProgrammingTextbook("JavaScript for Beginners", "Emma Davis", 320, "JavaScript");

        // Create 4 objects of EngineeringTextbook
        EngineeringTextbook et1 = new EngineeringTextbook("Structural Engineering", "Mark Lee", 600, "Structural Engineering");
        EngineeringTextbook et2 = new EngineeringTextbook("Electrical Engineering", "Sara Brown", 500, "Electrical Engineering");
        EngineeringTextbook et3 = new EngineeringTextbook("Civil Engineering Design", "Harry Wilson", 700, "Civil Engineering");
        EngineeringTextbook et4 = new EngineeringTextbook("Mechanical Principles", "Olivia Clark", 550, "Mechanical Engineering");

        // Create an ArrayList to store the textbooks
        ArrayList<Textbook> textbooks = new ArrayList<>();

        // Add objects to the list
        textbooks.add(pt1);
        textbooks.add(pt2);
        textbooks.add(pt3);
        textbooks.add(pt4);
        textbooks.add(et1);
        textbooks.add(et2);
        textbooks.add(et3);
        textbooks.add(et4);

        // Test methods for each object
        for (Textbook book : textbooks) {
            // Print the details using toString method
            System.out.println(book.toString());
            
            // Access and modify fields using get and set methods
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Pages: " + book.getPages());

            if (book instanceof ProgrammingTextbook) {
                System.out.println("Programming Language: " + ((ProgrammingTextbook) book).getLanguage());
            } else if (book instanceof EngineeringTextbook) {
                System.out.println("Engineering Subject: " + ((EngineeringTextbook) book).getSubject());
            }
            System.out.println("-------------------------------------------");
        }
    }
}
