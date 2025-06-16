import java.util.Scanner;

public class Student_Grade_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask how many subjects the student has
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int[] marks = new int[numSubjects]; // Array to store marks for each subject
        int totalMarks = 0;

        // Input: Take marks obtained (out of 100) in each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            // Optional: Check if marks are valid
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks!----- Please enter between 0 and 100.");
                i--; // reduce  this iteration
                continue;
            }
            totalMarks += marks[i]; // Calculate Total Marks
        }

        // Calculate Average Percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Grade Calculation based on average percentage
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display Results
        System.out.println("\n================ Result===============");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }
}
