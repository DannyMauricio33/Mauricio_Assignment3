import java.security.SecureRandom;
import java.util.Scanner;

public class CAI4 {
    // Initialize variables and objects needed for the code
    static Scanner scan = new Scanner(System.in);
    static SecureRandom random = new SecureRandom();
    private static int a;
    private static int b;
    private static int answer;
    private static int response;
    private static float correct = 0;
    private static int difficulty;

    public static void quiz() {
        //Ask user the difficulty level
        System.out.printf("Please enter the difficulty level (Type 1, 2, 3 or 4. 1 = least difficult, 4 = most difficult): ");
        readDifficulty();

        //Ask user the 10 questions based on the difficulty level
        askQuestion();

        //Print user's score and let them know if they passed or not
        displayCompletionMessage();

        //Ask user if they want to retry
        System.out.printf("Would you like to try and solve the problems again? Enter 1 for yes or 0 for no: ");
        int repeat = scan.nextInt();

        if(repeat == 1) {
            System.out.printf("\n");
            correct = 0;
            quiz();
        }

        else {
            System.exit(0);
        }

    }

    private static void readDifficulty() {
        difficulty = scan.nextInt();
    }

    private static void generateQuestionArgument() {
        if(difficulty == 1) {
            a = random.nextInt(10);
            b = random.nextInt(10);
        }

        else if(difficulty == 2) {
            a = random.nextInt(100);
            b = random.nextInt(100);
        }

        else if(difficulty == 3) {
            a = random.nextInt(1000);
            b = random.nextInt(1000);
        }

        else if(difficulty == 4) {
            a = random.nextInt(10000);
            b = random.nextInt(10000);
        }

        else {
            System.exit(0);
        }
    }

    private static void askQuestion() {
        for(int i = 0; i < 10; i++) {
            generateQuestionArgument();
            answer = a * b;
            System.out.printf("How much is %d times %d?\n", a, b);
            readResponse();

            if(isAnswerCorrect() == 1) {
                displayCorrectResponse();
                correct = correct + 1;
            }

            if(isAnswerCorrect() == 0) {
                displayIncorrectResponse();
            }
        }
    }

    private static void readResponse() {
        response = scan.nextInt();
    }

    private static int isAnswerCorrect() {
        if (response == answer) {
            return 1;
        }

        else {
            return 0;
        }
    }

    private static void displayCorrectResponse() {
        int c = random.nextInt(4) + 1;

        switch(c) {
            case 1:
                System.out.printf("Very good!\n\n");
                break;

            case 2:
                System.out.printf("Excellent!\n\n");
                break;

            case 3:
                System.out.printf("Nice work!\n\n");
                break;

            case 4:
                System.out.printf("Keep up the good work!\n\n");
                break;
        }
    }

    private static void displayIncorrectResponse() {
        int d = random.nextInt(4) + 1;

        switch (d) {
            case 1:
                System.out.printf("No. Please try again.\n\n");
                break;

            case 2:
                System.out.printf("Wrong. Try once more.\n\n");
                break;

            case 3:
                System.out.printf("Don't give up!\n\n");
                break;

            case 4:
                System.out.printf("No. Keep trying.\n\n");
                break;
        }
    }

    private static void displayCompletionMessage() {
        float result = correct / 10 * 100;

        System.out.printf("This is your score: %.1f%%\n", result);

        if((correct / 10) >= 0.75) {
            System.out.printf("Congratulations, you are ready to go to the next level!\n");
        }

        else {
            System.out.printf("Please ask you teacher for extra help.\n");
        }
    }

    public static void main(String[] args) {
        quiz();
    }
}
