import java.util.*;

public class Grade {
    public static void main(String[] args) {

        System.out.println("Software to generate a Letter Grade and percentage for a course taken by a student" + "\n");

        System.out.println("The Homework tests are for 20 marks and Quiz tests are for 10 marks. Please make sure input value doesn't exceed the maximum marks" + "\n");

        System.out.println("Team Members : Vasanth , B-NO : B00116672 and Ramesh B-NO : B00116634"+ "\n");

        
        final double homework_weightage = 0.15;
        final double quiz_weightage = 0.05;
        final double mid_term_exam_weightage = 0.25;
        final double final_exam_weightage = 0.3;
        final double final_project_weightage = 0.25;

        final int NUM_HOMEWORK = 8;
        final int NUM_QUIZZES = 5;

        final int MARKS_PER_HOMEWORK = 20;
        final int MARKS_PER_QUIZ = 10;
        final int MARKS_FOR_MID_TERM_EXAM = 100;
        final int MARKS_FOR_FINAL_EXAM = 100;
        final int MARKS_FOR_FINAL_PROJECT = 100;

        Scanner scanner = new Scanner(System.in);

        double homework_grade = get_average_marks("Homework", NUM_HOMEWORK, MARKS_PER_HOMEWORK);
        double quiz_grade = get_average_marks("Quiz", NUM_QUIZZES, MARKS_PER_QUIZ);
        double mid_term_exam_grade = get_marks("Mid-Term Exam", MARKS_FOR_MID_TERM_EXAM);
        double final_exam_grade = get_marks("Final Exam", MARKS_FOR_FINAL_EXAM);
        double final_project_grade = get_marks("Final Project", MARKS_FOR_FINAL_PROJECT);

        
        double total_grade = ((homework_grade * 5) * homework_weightage) +
                ((quiz_grade * 10) * quiz_weightage) +
                (mid_term_exam_grade * mid_term_exam_weightage) +
                (final_exam_grade * final_exam_weightage) +
                (final_project_grade * final_project_weightage);

        System.out.println("Final Percentage: " + (total_grade));

        System.out.println("Final Percentage: " + percentage_to_grade(total_grade));

        System.out.println("\n" + "Grade Equivalent to Percentages" + "\n");
        System.out.println("92 >= A <= 100");
        System.out.println("90 >= A- <= 91");
        System.out.println("87 >= B+ <= 89");
        System.out.println("82 >= B <= 86");
        System.out.println("80 >= B- <= 81");
        System.out.println("77 >= C+ <= 79");
        System.out.println("72 >= C <= 76");
        System.out.println("70 >= C- <= 71");
        System.out.println("67 >= D+ <= 69");
        System.out.println("62 >= D <= 66");
        System.out.println("60 >= D- <= 61");
        System.out.println("F <= 60");
    }

    private static double get_average_marks(String category, int numAssignments, int maxMarks) {
        Scanner scanner = new Scanner(System.in);
        double totalGrade = 0;

        System.out.println("\n" + "Enter Marks for " + category + ":" + "\n");
        for (int i = 1; i <= numAssignments; i++) {
            System.out.print("\n" + category + " " + i + ": ");
	try {
            double grade = scanner.nextDouble();
	
            
            if (grade > maxMarks) {
                System.out.println("Error , Please give a valid input.");
                i--; 
            } else {
                totalGrade += grade;
            }
        }
        catch (InputMismatchException e)
	{
		System.out.println("Please enter valid input");
		i--;
		scanner.nextLine();
	}
	}
	
        return totalGrade / numAssignments;
    }

    private static double get_marks(String category, int maxMarks) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Marks for " + category + ": ");
        double grade = scanner.nextDouble();

        if (grade > maxMarks) {
            System.out.println("Error , Please give a valid input.");
            return get_marks(category, maxMarks); 
        } else {
            return grade;
        }
    }

    private static String percentage_to_grade(double totalPercentage) {
        if (totalPercentage >= 92 && totalPercentage <= 100) {
            return "A";
        } else if (totalPercentage >= 90 && totalPercentage <= 91) {
            return "A-";
        } else if (totalPercentage >= 87 && totalPercentage <= 89) {
            return "B+";
        } else if (totalPercentage >= 82 && totalPercentage <= 86) {
            return "B";
        } else if (totalPercentage >= 80 && totalPercentage <= 81) {
            return "B-";
        } else if (totalPercentage >= 77 && totalPercentage <= 79) {
            return "C+";
        } else if (totalPercentage >= 72 && totalPercentage <= 76) {
            return "C";
        } else if (totalPercentage >= 70 && totalPercentage <= 71) {
            return "C-";
        } else if (totalPercentage >= 67 && totalPercentage <= 69) {
            return "D+";
        } else if (totalPercentage >= 62 && totalPercentage <= 66) {
            return "D";
        } else if (totalPercentage >= 60 && totalPercentage <= 61) {
            return "D-";
        } else {
            return "F";
        }
    }
    }