import java.util.Arrays;

public class ProcessMarks {

    // Method to find the maximum mark
    public static int max(int[] marks) {
        int maxMark = Integer.MIN_VALUE;
        for (int mark : marks) {
            if (mark > maxMark) {
                maxMark = mark;
            }
        }
        return maxMark;
    }

    // Method to find the minimum mark
    public static int min(int[] marks) {
        int minMark = Integer.MAX_VALUE;
        for (int mark : marks) {
            if (mark < minMark) {
                minMark = mark;
            }
        }
        return minMark;
    }

    // Method to find the range of the marks
    public static int range(int[] marks) {
        return max(marks) - min(marks);
    }

    // Method to calculate the mean of the marks
    public static double mean(int[] marks) {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }

    // Method to calculate the median of the marks
    public static double median(int[] marks) {
        int[] sortedMarks = marks.clone();
        Arrays.sort(sortedMarks);
        int n = sortedMarks.length;
        if (n % 2 == 1) {
            return sortedMarks[n / 2];
        } else {
            return (sortedMarks[(n / 2) - 1] + sortedMarks[n / 2]) / 2.0;
        }
    }

    // Method to calculate the mode of the marks
    public static int mode(int[] marks) {
        int[] sortedMarks = marks.clone();
        Arrays.sort(sortedMarks);

        int mode = sortedMarks[0];
        int maxCount = 0;
        int currentCount = 0;
        int currentMark = sortedMarks[0];

        for (int mark : sortedMarks) {
            if (mark == currentMark) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    mode = currentMark;
                }
                currentMark = mark;
                currentCount = 1;
            }
        }

        if (currentCount > maxCount) {
            mode = currentMark;
        }

        return mode;
    }

    // Method to assign grades based on marks
    public static char[] grades(int[] marks) {
        int[] boundaries = {90, 75, 60, 50, 45};
        char[] gradeLetters = {'A', 'B', 'C', 'D', 'E', 'F'};
        char[] grades = new char[marks.length];

        for (int i = 0; i < marks.length; i++) {
            int mark = marks[i];
            for (int j = 0; j < boundaries.length; j++) {
                if (mark >= boundaries[j]) {
                    grades[i] = gradeLetters[j];
                    break;
                }
                grades[i] = gradeLetters[gradeLetters.length - 1];  // Assign F if no other grade applies
            }
        }
        return grades;
    }

    // Method to calculate the distribution of grades
    public static int[] gradeDistn(char[] grades) {
        int[] distribution = new int[6];
        char[] gradeLetters = {'A', 'B', 'C', 'D', 'E', 'F'};

        for (char grade : grades) {
            for (int i = 0; i < gradeLetters.length; i++) {
                if (grade == gradeLetters[i]) {
                    distribution[i]++;
                }
            }
        }
        return distribution;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Gets tests marks
        int[] marks = Marks.getMarks();
        // int[] marks = {85, 78, 92, 45, 62, 89, 75, 77, 61, 44, 90};

        // Gets and prints grade statistics
        System.out.println("Max: " + max(marks));
        System.out.println("Min: " + min(marks));
        System.out.println("Range: " + range(marks));
        System.out.println("Mean: " + mean(marks));
        System.out.println("Median: " + median(marks));
        System.out.println("Mode: " + mode(marks));

        // Prints out grades as letter grades, new line every 30 grades
        char[] grades = grades(marks);
        System.out.print("Grades: \n");
        for (int i = 0; i < grades.length; i++) {
            System.out.print(grades[i] + (i % 30 == 29 ? "\n" : " "));
        }

        // Prints grade distribution
        System.out.println("\nGrade Distribution:");
        int[] distn = gradeDistn(grades);
        char[] gradeLetters = {'A', 'B', 'C', 'D', 'E', 'F'};
        for (int i = 0; i < distn.length; i++) {
            System.out.println(gradeLetters[i] + ": " + distn[i]);
        }
    }
}
