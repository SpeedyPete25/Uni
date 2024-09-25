import java.util.ArrayList;

public class Subject {
    private String name;
    private String subjectCode;

    // Constructor for Subject class
    public Subject(String name, String subjectCode) {
        if (!isValidCode(subjectCode)) {
            throw new IllegalArgumentException("Invalid subject code format.");
        }
        this.name = name;
        this.subjectCode = subjectCode;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    // Check if subject code matches the provided code
    public boolean codeMatches(String code) {
        return this.subjectCode.equals(code);
    }

    // toString method for Subject class
    @Override
    public String toString() {
        return subjectCode + ": " + name;
    }

    // Validate if the subject code is valid: first three letters and last three digits
    public static boolean isValidCode(String code) {
        if (code.length() != 6) {
            return false;
        }
        String alpha = code.substring(0, 3);
        String digits = code.substring(3, 6);
        return alpha.matches("[A-Za-z]+") && digits.matches("[0-9]+");
    }

    // Check if the subject code already exists in the list
    public static boolean codeExists(ArrayList<Subject> subjects, String code) {
        for (Subject subject : subjects) {
            if (subject.codeMatches(code)) {
                return true;
            }
        }
        return false;
    }
}
