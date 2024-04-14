import java.util.Scanner;

public class studentmarks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int numSub = scanner.nextInt();
        int totalMarks = 0;
        double average;
        for (int i = 1; i <= numSub; i++) {
            System.out.print("Enter the marks for subject " + i + ": ");
            int marks = scanner.nextInt();
            totalMarks += marks;
        }
        average = (double) totalMarks / numSub;
        char grade = calculateGrade(average);
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Marks: " + average);
        System.out.println("Grade: " + grade);
        scanner.close();
    }
    
    public static char calculateGrade(double average) {
        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}