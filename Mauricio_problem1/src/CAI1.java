import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {

    // Initialize variables and objects needed for the code
    static Scanner scan = new Scanner(System.in);
    static SecureRandom random = new SecureRandom();
    private static int answer;
    private static int response;

    public static void quiz() {
        // Print the question to the user
        askQuestion();

        // Initialize while loop to get user to continue to answer question if wrong
        while(true) {
            // Read the user's response
            readResponse();

            // If response is correct, print the correct response and break the loop
            if(isAnswerCorrect() == 1) {
                displayCorrectResponse();
                break;
            }

            // If response is wrong, print the incorrect response and loop will restart
            if(isAnswerCorrect() == 0) {
                displayIncorrectResponse();
            }
        }
    }

    private static void askQuestion() {
        int a = random.nextInt(10);
        int b = random.nextInt(10);
        answer = a * b;
        System.out.printf("How much is %d times %d?\n", a, b);
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
        System.out.printf("Very good!\n");
    }

    private static void displayIncorrectResponse() {
        System.out.printf("No. Please try again.\n");
    }

    public static void main(String[] args) {
        quiz();
    }
}


