import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3 {
    // Initialize variables and objects needed for the code
    static Scanner scan = new Scanner(System.in);
    static SecureRandom random = new SecureRandom();
    private static int answer;
    private static int response;
    private static float correct = 0;

    public static void quiz() {
        //Ask question and get its response from user
        askQuestion();

        //Return the user's score and let them know if they passed
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

    private static void askQuestion() {
        for(int i = 0; i < 10; i++) {
            int a = random.nextInt(10);
            int b = random.nextInt(10);
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
