

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Subject {

    // Method to read subjects from a file
    public static ArrayList<Subject> loadSubjectsFromFile(String filename) throws IOException {
        ArrayList<Subject> subjects = new ArrayList<>();
        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 2 && Subject.isValidCode(parts[0])) {
                subjects.add(new Subject(parts[1], parts[0]));
            }
        }
        reader.close();
        return subjects;
    }

    // Method to save subjects to a file
    public static void saveSubjectsToFile(ArrayList<Subject> subjects, String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Subject subject : subjects) {
            writer.write(subject.getSubjectCode() + "," + subject.getName());
            writer.newLine();
        }
        writer.close();
    }

    // Method to display all subjects
    public static void displaySubjects(ArrayList<Subject> subjects) {
        System.out.println("Existing subjects:");
        for (Subject subject : subjects) {
            System.out.println(subject);
        }
    }

    // Method to add new subjects
    public static void addNewSubjects(ArrayList<Subject> subjects) {
        Scanner scanner = new Scanner(System.in);
        String code, name;
        boolean addingSubjects = true;

        while (addingSubjects) {
            System.out.println("Enter subject name: ");
            name = scanner.nextLine();

            System.out.println("Enter subject code (3 letters + 3 digits): ");
            code = scanner.nextLine();

            while (Subject.codeExists(subjects, code)) {
                System.out.println("This code already exists! Please enter a new code:");
                code = scanner.nextLine();
            }

            if (Subject.isValidCode(code)) {
                subjects.add(new Subject(name, code));
            } else {
                System.out.println("Invalid subject code format. Please try again.");
            }

            System.out.println("Do you want to add another subject? (yes/no)");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                addingSubjects = false;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Subject> subjects = new ArrayList<>();
        String filename = "subjects.txt";

        try {
            // Load existing subjects from file
            subjects = loadSubjectsFromFile(filename);

            // Display current subjects
            if (!subjects.isEmpty()) {
                displaySubjects(subjects);
            }

            // Add new subjects
            addNewSubjects(subjects);

            // Save updated subjects to file
            saveSubjectsToFile(subjects, filename);

            System.out.println("Subjects have been saved to the file.");

        } catch (IOException e) {
            System.out.println("Error handling the file: " + e.getMessage());
        }
    }
}

